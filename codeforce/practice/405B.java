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
        int a=s.iint();
        int b=s.iint();
        String[] groupdecision=new String[a];
         for (int i=0;i<a ;i++ ) {
             groupdecision[i]=new String(s.next());
         }
         int consecutive_yes=1;
         boolean prev=false;
         if(groupdecision[0].equals("YES"))
            prev=true;
          int max=0;
         for (int i=0;i<a ;i++ ) {
             if(groupdecision[i].equals("YES"))
                consecutive_yes++;
            else
                prev=true;
         }
        System.out.println(max);
}
}