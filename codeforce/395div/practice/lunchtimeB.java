import java.io.*;
import java.util.*;
import java.math.*;

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
        int t=s.iint();
        while(t-->0)
        {
           int a=s.iint(),b=s.iint();
           Stack<Integer> st=new Stack<>();
           while(a>0 && b>0 ){
              int p=a%10;
              int q=b%10;
               p=p+q;
               a/=10;b/=10;
              st.push(p%10);

           }
           while(b>0){
            st.push(b%10);
            b/=10;
           }
           while(a>0){
            st.push(a%10);
            a/=10;
           }
           long ans=0;
           int count=st.size()-1;
           while(st.size()!=0){
               
               ans=ans+st.peek()*(int)Math.pow(10,count);
               st.pop();
               count--;
               
           }
           System.out.println(ans);
           
       }
}
}