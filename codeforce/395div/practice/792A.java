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
        int[] coordinate=new int[n];
        for (int i=0;i<n ;i++ ) {
            coordinate[i]=s.iint();
        }
        Arrays.sort(coordinate);
    
        int ans=2000000009;
        int noofpair=0;
        for (int i=0;i<n-1 ;i++ ) {
            if(Math.abs(coordinate[i]-coordinate[i+1])<ans)
               {
                noofpair=1;
                ans=Math.abs(coordinate[i]-coordinate[i+1]);
               }
            else if(Math.abs(coordinate[i]-coordinate[i+1])==ans)  
              {
                noofpair++;
              }
            
        }
        
        System.out.println(ans+" "+noofpair);
}
}