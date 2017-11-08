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
public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        int n=s.iint();
        int arr[]=new int[n];
        for (int i=0;i<n;i++ ) {
            arr[i]=s.iint();
        }
        int sum=0;
        
        int mx=1000000;
        for (int i=0;i<n;i++ ) {
            if(arr[i]>=0)
                sum+=arr[i];
        }
        if(sum%2==1)
        System.out.println(sum);
        else
        {
            for (int i=0;i<n ;i++ ) {
                if(Math.abs(arr[i])%2==1)
                    mx=Math.min(mx,Math.abs(arr[i]));
            }
            System.out.println(sum-mx);
        }
        
  }
}