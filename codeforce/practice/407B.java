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
public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        int b=s.iint();
        int q=s.iint();
        int l=s.iint();
        int m=s.iint();
        int[] w=new int[m];
        for (int i=0;i<m;i++ ) {
            w[i]=s.iint();
        }
        int b_i=b;
        Arrays.sort(w);
        int count=0,ans=0;
        while(Math.abs(b_i)<l && count<10000)
        {
              int low=0,high=m-1;
              int mid=0;
              boolean found=false;
              while(low<=high)
              {
                    int mid=(high-low)/2;
                    if(b_i>w[mid])
                        high=mid+1;
                     else if(b_i<w[mid])
                        low=mid;
                    else{
                        found=true;
                        break;

                    }
              }
              b_i=b_i*q;
              if(found)
                ans++;
            count++;

        }
        if(count<10000)
            System.out.println(ans);
         else
            System.out.println("inf");
        
}
}