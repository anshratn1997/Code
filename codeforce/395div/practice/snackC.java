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
     static class CustomComparator implements Comparator<Pair<Integer,Integer>>
{
    @Override
    public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2) {      
        
        return o2.getKey().compareTo(o1.getKey());
    }   
}
public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        int t=s.iint();
        while(t-->0)
        {
            int n=s.iint();
            int a[]=new int[n];
            int sum=0;

            for (int i=0;i<n ;i++ ) {
                a[i]=s.iint();
                sum=sum+a[i];
            }
             int m=1;
            if(n%2==0)
              n=n-1;
            int min=Integer.MAX_VALUE;
            int temp=0;
            while(2*m-1<=n)            

            {
              temp=sum-(m*m);
             // System.out.println(temp);
              if(temp<min && temp>=0){
                min=temp;
                System.out.println("heloo"+m);
              }
              m++;
                
            }
            System.out.println(min);
            
       }
        
   }
}