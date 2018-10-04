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
        int r=s.iint();
        while(r>0)
        {
            r--;
            int l=s.iint();
            int arr[]=new int[l];
            for (int i=0;i<l;i++ ) {
                arr[i]=s.iint();
            }
            if(l%2==0)
                System.out.println("no");
            else{
                boolean ans=true;

                if(arr[0]==1 && arr[l-1]==1){
                  for (int i=1;i<l/2;i++ ) {
                        if(arr[i]-arr[i-1]==1 && arr[l-2-i]-arr[l-1-i]==1 && arr[i]==arr[l-1-i])
                                continue;
                        else
                        {
                            ans=false;
                            break;
                        }
                 }
                 if(ans)
                    System.out.println("yes");
                 else
                     System.out.println("no");
               }
               else
                System.out.println("no");
            }
        }
    
       
}
}