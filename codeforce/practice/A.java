import java.io.*;
import java.util.*;
import java.math.*;
public class A {

static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }


   
    public static void main(String[] args) throws Exception{
    
    	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	  Reader r=new Reader();
          Integer n=r.nextInt();
    	  String s1=r.readLine();
          String s2=r.readLine();
          String[] ss1=s1.split(" ");
          String[] ss2=s2.split(" ");
        
          Integer a1[] =new Integer[n];
          Integer a2[]=new Integer[n];
          for (int i=0;i<n ;i++ ) {
              a1[i]=Integer.parseInt(ss1[i]);
              a2[i]=Integer.parseInt(ss2[i]);
              //System.out.println(a1[i]);
    
          }
          
         int[] af1=new int[6];
          int[] af2=new int[6];
    
          for (int i=0;i<n ;i++) {
            if(a1[i]==1)
                af1[1]++;
            else if(a1[i]==2)
             
               af1[2]++;
            else if(a1[i]==3)
                af1[3]++;
            else if(a1[i]==4)
                af1[4]++;
            else
                af1[5]++;
 
             if(a2[i]==1)
                af2[1]++;
            else if(a2[i]==2)
                af2[2]++;
            else if(a2[i]==3)
                af2[3]++;
            else if(a2[i]==4)
                af2[4]++;
            else
                af2[5]++;
            //System.out.println("hello");
              
          }
          boolean ans=true;

        
       
        int count=0;
        for (int i=1;i<=5 ;i++ ) {
            if(af1[i]>af2[i])
            {
                int max=af1[i]+af2[i];
                if(max%2==0){
                    max=af1[i]/2;
                    int mi=af1[1],l=1;
                   for (int j=2;j<=5;j++) {
                        if(af1[j]>mi)
                        {
                            mi=af1[j];
                            l=j;
                        }
                    }
                    af1[l]-=max;
                    af1[i]-=max;
                    count+=max;
                    af2[l]+=max;
                    af2[i]+=max;
                  //  System.out.println(af1[l]+" "+af2[l]+" "+l);
                   //ystem.out.println();
                }

                else
                {
                    ans=false;
                    break;
                }

            }
            else
            {
                int max=af1[i]+af2[i];
                if(max%2==0){
                    max=af2[i]/2;
                    int mi=af2[1],l=1;
                    for (int j=2;j<=5;j++) {
                        if(af2[j]>mi)
                        {
                            mi=af2[j];
                            l=j;
                        }
                    }
                    af2[l]-=max;
                    af2[i]-=max;
                    count+=max;
                    af1[l]+=max;
                    af1[i]+=max;
                    //System.out.println(af1[l]+" "+af2[l]+" "+l);
                    //System.out.println();
                }
                else
                {
                    ans=false;
                    break;
                }
            }


        }
        
        for (int i=1;i<=5 ;i++ ) {
            if(af1[i]!=af2[i])
                {ans=false;
                    break;}
        }
    		
            if(ans!=false)
                System.out.println(count/2);
            else
                System.out.println("-1");
           // */
    }
       
    		
    }

