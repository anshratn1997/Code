import java.io.*;
import java.util.*;
import java.math.*;
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

        int digit(int n)
        {
            int d=0;
            while(n>0)
            {n/=10;
                d++;

            }
            return d;
        }
        
    }
 

    public static void main(String[] args)
    {
        FastReader s=new FastReader();
           int t=s.iint();
           while(t-->0)
           {
            int x=s.iint();
            int y=s.iint();
            int count=1;
            if(x<=2 && y<=2)
                count=2;
               while(x>2 && y>2)
               {
                 if(x>y)
                 {
                    count++;
                    x=-2;
                    y=-1;
                 }
                 else
                 {

                    count++;
                    x=-1;
                    y=-2;
                 }
               }

               if(count%2==0)
                System.out.println("first");
              else
                System.out.println("second");
           }


    }
}