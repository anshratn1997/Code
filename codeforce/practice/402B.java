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
        int n = s.iint();
        int k = s.iint();
        int ans=0;
        int t1=n;

         if(n>(int )Math.pow(10,k))
         {
            int count_0=0;
            while(n>0)
            { 
                int t=n%10;
                if(t!=0 && count_0<k)
                {
                    ans++;
                  //System.out.println("ok1");
                }
                else if(t==0 && count_0<k)
                {
                     count_0++;
                     //System.out.println("ok2");
                }
                else
                    break;
                n/=10;

            }
            if(n==0 && count_0<k)
            {  
                    ans=s.digit(t1)-1;
            }
        
         }
         else if(n%(int)Math.pow(10,k)==0)
            ans=0;
         else 
         {
            
            ans=s.digit(t1)-1;
         }
         if(t1==0)
        System.out.println("0");
        else
        System.out.println(ans);
    }
}