import java.io.*;
import java.util.*;
import java.math.*;

 
//public 
class Main{
	static long mod1=1000000007L;
	static long mod2=1000000009L;
 
 BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      long t=li();
      while(t-->0){
      	long n=li();
      	n=n-1;
      	long numerator1=((n%mod1)*((n+1)%mod1))%mod1;
      	long numerator2=((n%mod2)*((n+1)%mod2))%mod2;
      	long denominator=2*(2*n-1);
      	long gd=gcd(numerator1,denominator);

      	numerator1/=gd;
      	denominator/=gd;
        System.out.print((numerator1*modInverse_1(denominator,mod1))%mod1+" ");
    
         
         denominator=2*(2*n-1);

      	gd=gcd(numerator2,denominator);
      	numerator2/=gd;
      	denominator/=gd;
      	System.out.print((numerator2*modInverse_1(denominator,mod2))%mod2);
      	System.out.println();
 
    }
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
   //input method
    int[] iint() throws IOException{
      String line[]=br.readLine().split(" ");
      int[] a=new int[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Integer.parseInt(line[i]);
      }
      return a;
    }
    long[] ilong() throws IOException{
      String line[]=br.readLine().split(" ");
      long[] a=new long[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    double[] idouble() throws IOException{
      String line[]=br.readLine().split(" ");
      double[] a=new double[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    long li() throws IOException{
      
      return Long.parseLong(br.readLine());
    }
    int ii() throws IOException{
      
      return Integer.parseInt(br.readLine());
    }
    double di() throws IOException{
      return Double.parseDouble(br.readLine());
    }
    char ci() throws IOException{
      return (char)br.read();
    }
    String si() throws IOException{
       return br.readLine();
    }
  long mul_mod(long base,long exp,long mod)
  {
     long res=1;
     while(exp>0){
       if(exp%2==1) res=(res*base)%mod;
       base=(base*base)%mod;
       exp/=2;
    }
    return res;
  }
 long modInverse(long a,long mod)
{
    long g = gcd(a,mod);
    if (g != 1)
        return 1;
    else
    {
        return power(a, mod-2,mod);
    }
}
long power(long x,long y,long mod)
{
    if (y == 0)
        return 1;
    long p = power(x, y/2,mod) % mod;
    p = (p * p) % mod;
 
    return (y%2 == 0)? p : (x * p) % mod;
}
long gcd(long a, long b)
{
    if (b == 0)
        return a;
    return gcd(b,a%b);
}
long modInverse_1(long a, long m)
{
    long m0 = m, t, q;
    long x0 = 0L, x1 = 1L;
 
    if (m == 1)
      return 0;
 
    while (a > 1)
    {
        // q is quotient
        q = a / m;
 
        t = m;
 
        // m is remainder now, process same as
        // Euclid's algo
        m = a % m;
        a = t;
 
        t = x0;
 
        x0 = x1 - q * x0;
 
        x1 = t;
    }
 
    // Make x1 positive
    if (x1 < 0)
       x1 += m0;
 
    return x1;
}
} 