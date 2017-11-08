import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
//public 
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
        int t=s.iint();
        while(t-->0){
        long n=s.ilong(),k=s.ilong();
        String st=s.next();
        long a[]=new long[(int)n];
        Arrays.fill(a,-1);
        long count_b=0;
        for (int i=(int)n-1;i>=0 ;i-- ) {
            if(st.charAt(i)=='b')
                count_b++;
            if(st.charAt(i)=='a')
                a[i]=count_b;
        }
        BigInteger ans=new BigInteger("0");
        for (int i=0;i<(int)n ;i++ ) {
            if(a[i]>=0)
            {
                if(a[i]==0)
                    ans=ans.add(BigInteger.valueOf(count_b*(((k-1)*k)/2)));
                else{
                    ans=ans.add(BigInteger.valueOf(a[i]*k));
                    ans=ans.add(BigInteger.valueOf(count_b*(((k-1)*k)/2)));
                }
            }
        }

System.out.println(ans);
        }
}
}