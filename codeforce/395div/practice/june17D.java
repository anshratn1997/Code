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
            try{
            br = new BufferedReader(new
                     InputStreamReader(System.in));

            }
            catch(Exception e){}
        
        
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
        long binHigherBound(long a[],long lo,long hi,long x){          
       if (lo > hi)
           return lo;
      long  mid = lo + (hi - lo) / 2;
     if (a[(int)mid] == x)
           return binHigherBound(a, mid+1, hi, x);
     else if (a[(int)mid] > x)
         return binHigherBound(a, lo, mid-1, x);
     else
         return binHigherBound(a, mid+1, hi, x);
          }      
    }
 
 
 public static void main(String[] args)
    {
        FastReader s=new FastReader();
        
        int t=s.iint();
        while(t-->0){
        long mod=1000000007;
        int p=s.iint();
        int q=s.iint();
        int r=s.iint();
        long A[]=new long[p];
        long B[]=new long[q];
        long C[]=new long[r];
        for (int i=0;i<p ;i++ ) {
            A[i]=s.ilong();
        }
        for (int i=0;i<q ;i++ ) {
            B[i]=s.ilong();
        }
        for (int i=0;i<r ;i++ ) {
            C[i]=s.ilong();
        }
        Arrays.sort(A);
        Arrays.sort(C);
        long sum_A[]=new long[p];
        sum_A[0]=A[0];
        long sum_C[]=new long[r];
        sum_C[0]=C[0];
        for(int i=1;i<p ;i++ ) {
            sum_A[i]=sum_A[i-1]+A[i];
            sum_A[i]=sum_A[i]%mod;
            //System.out.println(A[i]);
        }
        for (int i=1;i<r;i++ ) {
            sum_C[i]=sum_C[i-1]+C[i];
            sum_C[i]=sum_C[i]%mod;
        }
        //for (int i=0;i<p ;i++ ) {
          //  System.out.println(sum_A[i]);
        //}
        
        long sum=0;
        for (int i=0;i<q ;i++) {
            if(B[i]>=A[0] && B[i]>=C[0]){
           long index1=s.binHigherBound(A,0,p-1,B[i]);
           long index2=s.binHigherBound(C,0,r-1,B[i]);
           long temp1=0,temp2=0,temp3=0;
          // System.out.println(sum_A[(int)index1-1]+" "+sum_C[(int)index2-1]);
          // System.out.println(index1);
           //long ans=sum_C[(int)index2-1];
           //long temp=(index1*ans)%1000000007;
        
           temp1=(((((index1)*sum_C[(int)index2-1])%mod+(((index2)*sum_A[(int)index1-1])%mod))%mod)*B[i])%mod;
           temp2=(sum_A[(int)index1-1]*sum_C[(int)index2-1])%mod;
           temp3=((((index1)*(index2))%mod)*((B[i]*B[i])%mod))%mod;
            //System.out.println(temp1);
            //System.out.println(temp2);
            //System.out.println(temp3);
           sum=(sum+temp2+temp3+temp1)%mod;
           //System.out.println(sum);


            } 
         }
         System.out.println(sum);
       }
    }
}