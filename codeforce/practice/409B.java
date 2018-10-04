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
        String str1=s.next();
        String str2=s.next();
        boolean ans=true;
       
        char c[]=new char[str1.length()];
        for (int i=0 ;i<str1.length() ;i++ ) {
             if(str1.charAt(i)==str2.charAt(i)){
                
               c[i]=str1.charAt(i);    
            }
            else
            {
                int t1=str1.charAt(i);
                int t2=str2.charAt(i);
                if(t1<t2){
                    ans=false;
                  break;}
                 else{

                    c[i]=str2.charAt(i);
                }
            }
        }
        if(ans==false)
            System.out.println("-1");
         else
            {
                for (int i=0;i<str1.length();i++ ) {
                    System.out.print(c[i]);
                }
            }

        
        
}
}