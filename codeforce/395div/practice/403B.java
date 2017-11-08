import java.io.*;
import java.util.*;
import java.math.*;
class Mai
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
        boolean check(double key,int[] xi,int[] vi,int n)
        {
            int i=1;
            for(i=1;i<n;i++)
            {
                if(key==(Math.abs((xi[i]*1.0)-key))/vi[i])
                    continue;
                 else
                    break;
            }
            if(i==n)
                return true;
            else return false;
        }
        int minelement(int[] xi,int n)
        {
            int min=xi[0];
            for (int i=1;i<n ;i++ ) {
                if(min>xi[i])
                    min=xi[i];

            }
           return min;
        }
        
    }
 

    public static void main(String[] args)
    {
        FastReader s=new FastReader();
           int n=s.iint();
           int[] xi=new int[n];
           int[] vi=new int[n];
           
           for (int i=0;i<n ;i++ ) {
               xi[i]=s.iint();
           }
           for (int i=0;i<n ;i++ ) {
               vi[i]=s.iint();

           }
           double max=1000000001.0,min=0.0;
           double key=0.0;
           while(min<max)
           {
              key=((max+min)*1.0)/2;
               if(s.check(key,xi,vi,n) )
                  {
                       if(key<s.minelement(xi,n))
                         min=key;

                  }
                 else
                    max=key;
                   
           }
           System.out.println(key);



    }
}