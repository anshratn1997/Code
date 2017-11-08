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
         
        public FastReader ()
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
    }
 
 
 public static void main(String[] args)
    {
        FastReader s=new FastReader();
        int t=s.iint();
        while(t-->0){
            long n=s.ilong();
            Long[] a=new Long[(int)n];
            long sum_positive=0;
            long sum_negative=0;
            int count=0;
            
            for (int i=0;i<n ;i++ ) {
              a[i]=s.ilong(); 

            }
            Arrays.sort(a,Collections.reverseOrder());
            int i=0;
            for (i=0;i<n ;i++ ) {
                if(a[i]>=0)
                {
                    sum_positive+=a[i];
                    count++;
                }
                else
                    break;
            }
            for (int j=i;j<n ;j++ ) {
                if((sum_positive+a[j])*(count+1)>sum_positive*count){
                    sum_positive+=a[j];
                    count++;
                    //System.out.println(a[j]);
                }
                else
                    sum_negative+=a[j];
            }
            
            System.out.println(sum_negative+sum_positive*count);
       }
        
        
    }
}