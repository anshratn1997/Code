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
        int t=s.iint();
        while(t>0)
        {
            int a=s.iint();
            int b=s.iint();
            
            int i=0;
            
            while(a>=0 || b>=0)
            {
                i++;
                if(i%2!=0){
                    a=a-i;
                    //System.out.println("a "+a);
                }
                else{
                    b=b-i;
                   // System.out.println("b "+b);
                }

                if(a<0)
                {
                    System.out.println("Bob");
                    break;
                }
                if(b<0)
                {
                    System.out.println("Limak");
                    break;
                }

            }
            t--;
        }

        
}
}