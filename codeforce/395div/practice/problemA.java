//PROBLEM A SOLUTION


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
        int n=s.iint();
        int arr[]=new int[n];
        StringBuffer ans=new StringBuffer("");
        for (int i=0;i<n ;i++ ) {
            arr[i]=s.iint();
        }
        if(n>=2){
        if(arr[n-1]-arr[n-2]>0 && arr[n-1]!=15)
            ans.append("UP");
        else if(arr[n-1]-arr[n-2]>0 && arr[n-1]==15)
            ans.append("DOWN");
        else if(arr[n-1]-arr[n-2]<0 && arr[n-1]!=0)
            ans.append("DOWN");
        else if(arr[n-1]-arr[n-2]<0 && arr[n-1]==0) 
            ans.append("UP");
        
           }
           else
           ans.append("-1"); 
         System.out.println(ans);

       
}
}