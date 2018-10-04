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
        
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=s.iint();

        }
        for (int i=0;i<n ;i++ ) {
            b[i]=s.iint();
            
        }
        boolean change=false;
        int count=0;
        int location=-1;
        HashSet<Integer> set =new HashSet<>();
        for (int i=0;i<n ;i++ ) {
            if(a[i]!=b[i]){
                count++;
                location=i;
            }
            else{
            c[i]=a[i];
            set.add(a[i]);
        }        }
        if(count==1)
        {
            for (int i=1;i<=n ;i++ ) {
                if(!set.contains(i)){
                    c[location]=i;
                    break;
                }
            }

        }
        else{
            int temp=1;
        for (int i=0;i<n ;i++ ) {
            
                if(a[i]!=b[i] ){
                    if(temp%2!=0)
                        c[i]=b[i];
                    else
                        c[i]=a[i];
                    temp++;
                
               }
          }
        
}
        for (int i=0; i<n;i++ ) {
             System.out.print(c[i]+" ");
        }
        
    }
}