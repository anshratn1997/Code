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
        int n=s.iint();
        int k=s.iint();
        int a[]=new int[n];
        int b[]=new int[k];
      int count=0;
      int location=-1;
        for (int i=0;i<n ;i++ ) {
            a[i]=s.iint();
           if(a[i]==0){
             count++;
             location=i;
           }
        }
        for (int i=0;i<k ;i++ ) {
            b[i]=s.iint();
        }
         if(k==1)
         {
            boolean ans=true;
            a[location]=b[0];
            for (int i=1;i<n ;i++ ) {
                if(a[i]>a[i-1])
                    continue;
                else{
                      ans=false;
                      break;
                      }
            }
            if(ans)
                System.out.println("No");
            else
                System.out.println("Yes");
         }
        else
            System.out.println("Yes");
       
        


    }
}