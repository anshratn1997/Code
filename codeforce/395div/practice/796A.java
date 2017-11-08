import java.io.*;
import java.util.*;
import java.math.*;
 public class Mai
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
        
        boolean check(String s1,String s2,int len)
        {
            boolean foundinsertion=false;
            for (int i=0;i<len ;i++ ) {
                if(s1.charAt(i)!=s2.charAt(i))
                {
                    foundinsertion=true;
                    i--;
                }
                

            }
            return true;
        }
  
    }
 
 public static void main(String[] args)
    {
        FastReader s=new FastReader();
         int n=s.iint(),m=s.iint(),k=s.iint();
         int ai[]=new int[n];
         for (int i=0;i<n ;i++ ) {
             ai[i]=s.iint();
         }
         int min1=k,min2=k,loc1=-999999,loc2=1000000;
         for (int i=m-2;i>=0 ;i-- ) {
             if(ai[i]!=0 )
             {
                if(ai[i]<=k){
                    min1=ai[i];
                    loc1=i;
                    break;
                }

                
             }
         }
         for (int i=m;i<n ;i++ ) {
             if(ai[i]!=0 )
             {
                if(ai[i]<=k){
                    min2=ai[i];
                loc2=i;
                break;}
             }
         }
       loc1=m-1-loc1;
       loc2=loc2-m+1;
        //System.out.println(loc1);
        //System.out.println(loc2);
         System.out.println((Math.min(loc1,loc2))*10);
    }
}