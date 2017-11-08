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
        String st=s.next();
        boolean ans=true;
        boolean change=false;
        for (int i=0;i<st.length()/2 ;i++ ) {
            if(st.charAt(i)!=st.charAt(st.length()-1-i) && change==false)
                change=true;
             else if(st.charAt(i)!=st.charAt(st.length()-1-i) && change==true)
             {
                      ans=false;
             }
               
        }
        if(st.length()%2!=0)
       {
         if(ans==true)
            System.out.println("YES");
        else
            System.out.println("NO");
       }
       else
       {
         if(ans==true && change==true)
            System.out.println("YES");
        else
            System.out.println("NO");
       }

        
}
}