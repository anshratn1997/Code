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
        String arr=s.next();
        int count1=0,count2=0;
     int len=arr.length();
    // System.out.println(len);
     int u[]=new int[len];
     int d[]=new int[len];
     for (int i=len-1;i>=0;i-- ) {
         if(arr.charAt(i)=='U'){
            count1=0;
         }
         else{
            count1++;
            d[i]=count1;
         }
         if(arr.charAt(i)=='D'){
            count2=0;
         }
         else{
            count2++;
            u[i]=count2;
         }
     }
     count1=0;count2=0;
     for (int i=0;i<len;i++ ) {
         if(d[i]!=0)
         {
            count1++;
            i=i+d[i];
         }
     }
     //for (int i=0;i<len ;i++ ) {
   //      System.out.print(u[i]);
    // }
     for (int i=0;i<len;i++ ) {
         if(u[i]!=0)
         {
            //System.out.println(i);
            //if(i==3)
              //  System.out.println(d[i]);
            count2++;
            i=i+u[i];

            
         }
     }
     //System.out.println(count1+" "+count2);

     System.out.println(Math.min(count2,count1));
        
}
    }
}