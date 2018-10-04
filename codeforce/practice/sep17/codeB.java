import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    

  
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      int t=1;
      //.System.out.println(gcd(4,6));
      t=ii();
      while(t-->0){
        int n=ii();
       
        int ct=0;
        int a[]=new int[n];
        for (int i=0;i<n;i++ ) {
           a[i]=i+1;
        }
        double sum=0L;
        int time=0;
        for (int i=0;i<n;i++) {
                    int lf=0;
                   for (int k=i;k<n;k++ ) {
                    //System.out.println("fdsfo");
                       time++;
                        if(i%2==0){
                          int mid=(lf+k)/2;
                          lf++;
                         // System.out.println(mid);
                          sum+=a[mid];

                        }
                        else
                        {
                          int mid=(lf+k)/2;
                          lf++;
                          if(mid+1<n)
                           sum=sum+((a[mid]+a[mid+1])*1.0)/2.0;
                        }
                   }
          }
          System.out.println(time);
          System.out.println(sum);
          double l=(n-1)*1.0;
          double r=(n+1)*1.0;
          double ans=sum/(time*1.0);
          System.out.println(ans);
          System.out.println(l);
          System.out.println(r);
          if(ans>=l && ans<=r)
           {
            for (int i=1;i<=n ;i++ ) {
              System.out.print(i+" ");
            }
            System.out.println();
           }
           else
            System.out.println("-1");
     }
     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  int gcd(int a,int b){
    if(b==0)
      return a;
    a=a%b;
    return gcd(b,a);
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
    
} 