import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
 public class Main
{

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
         
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int iint()
        {
            return Integer.parseInt(next());
        }
 
        long ilong()
        {
            return Long.parseLong(next());
        }
 
        double idouble()
        {
            return Double.parseDouble(next());
        }
 
        String readline()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int makeequal(StringBuffer sb1,StringBuffer sb2)
        {
            int count=-1;
            char[] ch1=sb1.toString().toCharArray();
            char[] ch2=sb2.toString().toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            String st1=new String(ch1);
            String st2=new String(ch2);
            if(st1.equals(st2))
                count=0;
             else
                return count;
            boolean notpossible=true;
            for(int i=0;i<sb1.length();i++)
            {
                if(sb1.toString().equals(sb2.toString())){
                    notpossible=false;
                    break;
                }
                else
                {
                    char[] ch=new char[1];
                    ch[0]=sb2.charAt(0);
                    sb2.deleteCharAt(0);
                    sb2.append(new String(ch));
                    count++;

                }
            }
            if(notpossible==false)
            return count;
            else
               return -1;
        }

    }
public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        
       // System.out.println(s.makeequal(new StringBuffer("zwoxz"),new StringBuffer("xzzwo")));
        //System.out.println(s.makeequal(new StringBuffer("zwoxz"),new StringBuffer("zzwox")));
        //System.out.println(s.makeequal(new StringBuffer("zwoxz"),new StringBuffer("xzzwo")));

       // /*
        int n=s.iint();
        String[] arrayst=new String[n];
        for (int i=0;i<n ;i++ ) {
            arrayst[i]=s.next();
        }
        
        boolean ans=false;
        int sum=0;
        int minmove=10000000;
        int len=arrayst[0].length();
        //int[] sumarray=new int[n];
        for (int i=0;i<n ;i++ ) {
            StringBuffer sb=new StringBuffer(arrayst[i]);
            for (int j=0;j<len ;j++ ) {
                 char c=sb.charAt(0);
                 sb.deleteCharAt(0);
                  sb.append(c);
                      sum=0;
                  for (int k=0;k<n ;k++ ) {
                     if(i!=k)
                     {
                        if(s.makeequal(sb,new StringBuffer(arrayst[k]))<0)
                        {
                            ans=true;
                            break;
                        }
                        else
                            sum+=s.makeequal(sb,new StringBuffer(arrayst[k]));

                     } 
                  }
                  //System.out.println(sum);
                  if(j!=len-1)
                  sum=sum+j+1;
                  if(sum<minmove)
                    minmove=sum;

            }
                
        }
            
            
        
       
        
        
        if(ans==false){
            System.out.println(minmove);
        }
        else
            System.out.println("-1");
}
}