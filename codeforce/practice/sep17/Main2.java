import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main2{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
   

    // .......static class
  
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new Main2().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     out=new PrintWriter(System.out);
      int t=1;
      t=ii();
      
      while(t-->0){

        //........solution start
       // lest();
        int line[]=iint();
        int n=line[0],m=line[1];
        //System.out.println(n+" "+m);
        long[][] a=ilm(n,m);

        long[][] dp=new long[n][m];
        for (int i=0;i<m ;i++ ) {
           dp[n-1][i]=a[n-1][i];
        }

        for (int i=n-2;i>=0 ;i-- ) {

          for (int j=m-1;j>=0 ;j-- ) {
              long max=0;
              for(int k=0;k<m;k++){
                 if(gcd(a[i][k],a[i+1][j])!=1)
                 max=Math.max(dp[i+1][j]+a[i][k],max);
              }
              if(max==0)
                dp[i][j]=a[i][j];
               else
                dp[i][j]=max;
            
          }
          
        }
      long ans=0L;
      for (int i=0;i<n ;i++ ) {
        
         for (int j=0;j<m ;j++ ) {
           
            ans=Math.max(ans,dp[i][j]);
            //System.out.print(dp[i][j]+" ");
         }
        // System.out.println();
      }
        
        System.out.println(ans);

        
       







        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.

  long gcd(long a, long b) {  
        while (b > 0) {
            long c = a;
            a = b;
            b = c % b;
        }
        return a;
    }

  


  //................end.
  
  
   //..............input method start. 
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