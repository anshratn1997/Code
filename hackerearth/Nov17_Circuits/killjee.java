import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    //static variable
    static final long mod = (int) 1e9 + 7;
    // static final long mod = 11;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    static long[] fib=new long[2*1000001];
    static long[] fac=new long[2*1000001];

    // .......static class
  static class Pair{
      int key,value;
      Pair(int key,int value){
        this.key=key;
        this.value=value;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
      }
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Integer key1=o1.Key(),key2=o2.Key();
          return key1.compareTo(key2);
     }
  }
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
       
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
      fibonacci();
      factorial();
      int t=1;
      t=ii();
      while(t-->0){

        //........solution start


        long[] tt=ilong();
        long n=tt[0],m=tt[1],k=tt[2];
       
        long sum=0L;
        for (int i=(int)n;i<=(int)m ;i++ ) {
           long temp=(fib[i]*((1L*fac[i])%mod))%mod;
           // System.out.println("temp "+temp);
           sum+=temp;
           sum=sum%mod; 
        }
         // System.out.println(sum);
         int ans=1;
         ArrayList<Integer> al=new ArrayList<>();
         al.add(1);
        for (int i=1;i<=2*1000000 ;i++ ) {
              long temp=(k*((1L*i)%mod))%mod;
               if(temp<=sum)
                  {
                    al.add(i);
                  }

        }
        Collections.sort(al);
        System.out.println(al.get(al.size()-1));


      

  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  void fibonacci(){
    fib[0]=1;fib[1]=1;
    for (int i=2;i<=2*1000000 ;i++ ) {
          fib[i]=fib[i-1]+fib[i-2];
          fib[i]=fib[i]%mod;
    }
  }
  void factorial(){
    fac[0]=1;fac[1]=1;
    for (int i=2;i<2*1000001 ;i++ ) {
       fac[i]=(i*(1L*fac[i-1])%mod)%mod;
    }
  }
long modInverse(long a, long m)
{
    long g = gcd(a, m);
    if (g != 1)
        return 1;
    else
    {
        // If a and m are relatively prime, then modulo inverse
        // is a^(m-2) mode m
       
        return power(a, m-2);
    }
}
 
// To compute x^y under modulo m
 long power(long x, long y)
{
    long res = 1;      // Initialize result
 
    x = x % mod;  // Update x if it is more than or 
                // equal to p
 
    while (y > 0)
    {
        // If y is odd, multiply x with result
        if (y % 2==1)
            res = (res*x) % mod;
 
        // y must be even now
        y = y>>1; // y = y/2
        x = (x*x) % mod;  
    }
    return res;
}
 
long gcd(long a, long b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
}


     



  //................end.
  
  
   //..............input method start. 
    int getmax(int a[]){
      int n=a.length;
      int max=a[0];
      for (int i=1;i<n ;i++ ) {
        max=Math.max(a[i],max);
      }
      return max;
    }
     int getmin(int a[]){
      int n=a.length;
      int min=a[0];
      for (int i=1;i<n ;i++ ) {
        min=Math.min(a[i],min);
      }
      return min;
    }

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
    String[] isa(int n) throws IOException{
        String at =si();
        return at.split(" ");
    }

    double[][] idm(int n, int m) throws IOException{
        double a[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
          double[] temp=idouble();
          for (int j = 0; j < m; j++) a[i][j] = temp[j];
        }
        return a;
    }

    int[][] iim(int n, int m) throws IOException{
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
          int[] temp=iint();
          for (int j = 0; j < m; j++) a[i][j] =temp[j];
        }
        return a;
    }
    long[][] ilm(int n, int m) throws IOException{
       long a[][] = new long[n][m];
        for (int i = 0; i < n; i++) {
          long[] temp=ilong();
          for (int j = 0; j < m; j++) a[i][j] =temp[j];
        }
        return a;
    }
    //..............input methods end;
    
} 