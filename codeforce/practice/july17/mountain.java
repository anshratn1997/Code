import java.io.*;
import java.util.*;
import java.math.*;
//public 
class mountain{
    
    static long mod=1000000007L;
    BufferedReader br;
    public static void main(String[] args) {
    new mountain().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      long n=li();
      if(n<=2)
        System.out.println(0);
      else{
      n=n-1;
      //System.out.println(Math.pow(2,n));
      long res=power(2,n,mod);
      res=res-2;
      System.out.println(res);}

     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  
 long power(long x,long y,long mod)
{
    if (y == 0)
        return 1;
    long p = power(x, y/2,mod) % mod;
    p = (p * p) % mod;
 
    return (y%2 == 0)? p : (x * p) % mod;
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
}


    