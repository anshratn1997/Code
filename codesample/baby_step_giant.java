/*
This is meet in middle alogorithm .
link of problem-https://www.hackerearth.com/challenge/competitive/june-circuits-17/algorithm/dexter-plays-with-gp-1/

It  calculates the
value of x where you have r, mod,b;
r^x=b%mod;

@keep_doing_practice.

*/



import java.io.*;
import java.util.*;
import java.math.*;
public class  hacker3{
    static long mod=0L;
    
    public static void main(String[] args) {
    new hacker3().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     //System.out.println(modInverse(0));
     int t=Integer.parseInt(br.readLine());
     while(t-->0){
     String line[]=br.readLine().split(" ");
     long r=Long.parseLong(line[0]);
     long s=Long.parseLong(line[1]);
     long p=Long.parseLong(line[2]);
     mod=p;
     long b=(s*(r-1)+1)%p;
     if(b==0){
      System.out.println("-1");
      continue;
       }
     long ans=baby_step_giant_step(r,b,p);
     if(ans==0)
      System.out.println("-1");
      else
        System.out.println(ans);
    }    
  }
    catch(Exception e){
        e.printStackTrace();

    }

  }
  long mul_mod(long base,long exp)
  {
     long res=1;
     while(exp>0){
       if(exp%2==1) res=(res*base)%mod;
       base=(base*base)%mod;
       exp/=2;
    }
    return res;
  }
 long modInverse(long a)
{
    long g = gcd(a,mod);
    if (g != 1)
        return -1;
    else
    {
        return power(a, mod-2);
    }
}
long power(long x,long y)
{
    if (y == 0)
        return 1;
    long p = power(x, y/2) % mod;
    p = (p * p) % mod;
 
    return (y%2 == 0)? p : (x * p) % mod;
}
long gcd(long a, long b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
}
long baby_step_giant_step(long r,long b,long p){
  
  long m=(long)Math.ceil(Math.sqrt(p));
  long rev=power(modInverse(r),m);
  HashMap<Long,Long> map=new HashMap<>();
  long a=1;
  for (int i=0;i<m ;i++ ) {
     map.put(a,(long)i);
     a=(a*r)%p;

  }
  for (int i=0;i<m ;i++ ) {
     if(map.containsKey(b)){
      return i*m+map.get(b);
     }
     b=(b*rev)%p;
  }
 return 0;
}
}