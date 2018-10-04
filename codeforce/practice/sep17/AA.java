import java.io.*;
import java.util.*;
import java.math.*;
public class Main{
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
      // t=ii();
      while(t-->0){
       long[] temp=ilong();
      long n=temp[0],k=temp[1];
      long rem=n%10;
      long tt=n;
      if(k!=0){
        long count=0;
        long min=Long.MAX_VALUE;
        if(coutn_zero(tt)>=k)
        min=tt;
      else{
        for(int i=1;i<9;i++ ) {
         long fuck=tt*i;
         long digit=1L;
         count=0;
         if(fuck%10==0)
            {
              digit=i;
              count=coutn_zero(fuck);
              if(count>=k)
                min=Math.min(tt*i,min);
              else{min=Math.min(tt*i*(long)Math.pow(10,k-count),min);}
               
             
            }

       }
     }
       if(min==Long.MAX_VALUE)
        System.out.println(tt*(long)Math.pow(10,k));
       else
       System.out.println(min);

       
     }
    else
    System.out.println(tt);
  }

     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  long coutn_zero(long num){
   long count=0L;
    while(num>0){
      long rem=num%10;
      if(rem==0)
        {num/=10;count++;}
      else break;
    }
    return count;
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