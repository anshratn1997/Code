import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   static long MOD=1000000009;
    static long ncr[][];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        constructNcr();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            long k = in.nextLong();           
            long result = highwayConstruction(n-1, k);           
           if(result==-1l)
                System.out.println("0");
            else
                System.out.println((result-1+MOD)%MOD);  
            
        }
        in.close();
      
    }
    //  I assume that k=m;
    
     static long highwayConstruction(long n, long m) {
          if(n<=1)
            return -1l;
         long berSum[]=new long[(int)m+2];
         berSum[0]=0;
         n=n%MOD;
         long i=1;
         for(i=1;i<=m+1;i++){
             long val1=modInverse(i+1,MOD);
             long val2=pow(n,i+1,MOD)%MOD;
             long val3=0;
             for(long j=1;j<=i-1;j++){
                 val3=val3+((getnCr(i+1,j)*berSum[(int)j])%MOD);
                 val3=val3%MOD;
             }
             long t1=(n+val3)%MOD;
             long t2=(val2-t1+MOD)%MOD;
             berSum[(int)i]=(val1*t2)%MOD;
         }
         long S=n;
         for(i=1;i<=m-1;i++){
             S=S+((getnCr(m,i)*berSum[(int)i])%MOD);
             S=S%MOD;
         }
         S=S+berSum[(int)m];
         return S%MOD;
    }
   
    static long getnCr(long n,long r){
        return ncr[(int)n][(int)r];
    }   
    static long modInverse(long a, long m) {
        return pow(a,m-2,m);
    } 
    static long pow(long a, long b, long MOD) {
        long x = 1, y = a;
        while(b > 0) {
            if(b%2 == 1) {
                 x=(x*y);
                 if(x>=MOD) 
                     x%=MOD;
             }
             y = (y*y);
            if(y>=MOD) 
                y%=MOD;
             b /= 2;
        }
        return x%MOD;
    }
    public static void constructNcr(){
        ncr=new long[1005][1005];
         ncr[0][0]=1;
        ncr[1][0]=ncr[1][1]=1;
        for(int k=2;k<1005;k++){
            ncr[k][0]=1;
        }
        for(long i=2;i<=1004;i++){
            long j=1;
            for(j=1;j<=i/2;j++){
                long val1=(ncr[(int)i][(int)j-1]*(i-j+1))%MOD;
                long val2=modInverse(j,MOD);
                ncr[(int)i][(int)j]=(val1*val2)%MOD;
            }
            long k=i/2;
            if(i%2==0)
                k=i/2-1;
            while(k>=0){
                ncr[(int)i][(int)j]=ncr[(int)i][(int)k];
                j++;
                k--;
            }
        }
    }
    
}