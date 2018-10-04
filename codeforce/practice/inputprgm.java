import java.io.*;
import java.util.*;

class Main
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
        int n = s.iint();
        int k = s.iint();
        System.out.println(s.gcdIterative(40,8));
        //System.out.println(count);
    }
}