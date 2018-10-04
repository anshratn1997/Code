import java.io.*;
import java.util.*;
import java.math.*;
public class M
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
        
    }
 

    public static void main(String[] args)
    {
        FastReader s=new FastReader();
           int n=s.iint();
           Integer a[]=new Integer[2*n];
           int ass[]=new int[n+1];
           for (int i=0;i<2* n ;i++ ) {
               a[i]=new Integer(s.iint());

           }
           int max=0,count=0;
           for (int i=0;i<2*n ;i++ ) {
                 if(ass[a[i]]==0){
                    ass[a[i]]=1;
                    count++;
                }
                else
                {
                    count--;
                    ass[a[i]]=0;
                }
                if(max<count)
                    max=count;
           }
           System.out.println(max);


       }


    }
