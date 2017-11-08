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
      t=ii();
      while(t-->0){
        int tt[]=iint();
        int n=tt[0],k=tt[1];
        if(k==0||k==n)
          System.out.println("0 0");
       else if(k<=n/3)
          System.out.println("1 "+(k*2));
       else if(k*2==n)
          System.out.println("1 "+n/2);
      else if((n/3)<k<(n/2)){
          int el=n/3;
          int left=n-(el*3);
          int left_k=k-el;
          int avail=el*2+left;
           System.out.println("1 "+(avail-left_k)); 
        }
        else{
           if(n%2==0){
            int max=n/2;
            max=max-(k-n/2);
            System.out.println("1 "+max);
           }
           else
           {
            int max=n/2+1;
            max=max-(k-n/2);
            System.out.println("1 "+max);
           }

        }
       
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