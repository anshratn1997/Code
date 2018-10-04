import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
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
 
    
    public static void main(String[] args) throws Exception{
        
    
        FastReader s=new FastReader();
        BufferedWriter wr=new BufferedWriter(new OutputStreamWriter(System.out));
        long curentbarn= s.ilong();
        long brought=s.ilong();
       
         long low=0,high=(long)2e9;
         long mid=0;
         if(brought>=curentbarn)
         {
            System.out.println(curentbarn);
         }
         else{
            curentbarn=curentbarn-brought;
         while(low<high)
         {
            mid=(high+low)/2;
            long sum=mid*(mid+1)/2;
            if(sum>=curentbarn)
                high=mid;
            else{
                low=mid+1;
            }

         }
         wr.write(Long.toString(low+brought));
     }
        
}
}