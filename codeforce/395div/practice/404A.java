import java.io.*;
import java.util.*;
import java.math.*;
 class M
{

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
         
        public FastReader ()
        {
            try{
            br = new BufferedReader(new
                     InputStreamReader(new FileInputStream("abc.txt")));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
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
        int gcdIterative(int bigger, int smaller) {
        while (true) {
        int remainder = bigger % smaller;
        if(remainder==0){
              return smaller;
         }
        else{
          bigger=smaller;smaller=remainder;
             }
          }
        }
        
    }
 

    public static void main(String[] args)
    {
        FastReader s=new FastReader();
           int n=s.iint();
           String[] str=new String[n];
           int ans=0;
           for (int i=0;i<n ;i++ ) {
               str[i]=new String(s.next());
               if(str[i].equals("Tetrahedron"))
                ans+=4;
               else if(str[i].equals("Cube"))
                       ans+=6;
               else if(str[i].equals("Octahedron"))
                ans+=8;
               else if(str[i].equals("Dodecahedron"))
                    ans+=12;
                 if(str[i].equals("Icosahedron"))
                        ans+=20;
           }
            try{
                System.out.println("hello");
                PrintWriter pwr=new PrintWriter("output.txt");
                pwr.println(ans);
                pwr.flush();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
             
          
       }


    }
