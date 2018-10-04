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

    // .......static class
  
    
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
      int t=1;
     // t=ii();
      while(t-->0){

        //........solution start herr

        int tt[]=iint();
        int n=tt[0],m=tt[1];
         long ans=n*2L*m;
        int[][] a=iim(n,m);
        int row=0,col=0;
        for (int i=0;i<m ;i++ ) {
              col+=col_max(a,i,n);
        }
        for (int i=0;i<n ;i++ ) {
           row+=row_max(a,i,m);
        }
        
        ans+=2*row;
        ans+=2*col;
        //int[][] a={{1},{2},{1},{3},{2},{4},{1},{3},{2}};
         // int[][] a={{4},{3},{2},{1}};
         // System.out.println(depth_col(a,0,4));
       int total=0;
      for (int i=0;i<n ;i++ ) {
          int temp=depth_row(a,i,m);
          total+=(2*temp);
      }
      for (int i=0;i<m ;i++ ) {
          int temp=depth_col(a,i,n);
          total+=(2*temp);
      }
      ans+=total;
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
  int depth_row(int[][] a,int i,int m){
       
       int[] ma=new int[m];
       ma[m-1]=a[i][m-1];
      
       for (int j=m-2;j>=0 ;j-- ) {
          if(a[i][j]>ma[j+1])
             ma[j]=a[i][j];
           else
            ma[j]=ma[j+1];
       }
       int sum=0;
       int max=0;
       if(m>=2)
       max=Math.min(a[i][0],ma[1]);
       
       for (int j=1;j<m-1;j++ ) {
          
          if(max>a[i][j])
          {
            sum+=(max-a[i][j]);            
           
          }
        max=Math.min(ma[j+1],a[i][j]);
        //System.out.println(sum+" "+max);

       }
        return sum;
  }
  int depth_col(int[][] a,int j,int m){
       
       int[] ma=new int[m];
       ma[m-1]=a[m-1][j];
      
       for (int i=m-2;i>=0 ;i-- ) {
          if(a[i][j]>ma[i+1])
             ma[i]=a[i][j];
           else
            ma[i]=ma[i+1];
       }
       int sum=0;
       int max=0;
       if(m>=2)
       max=Math.min(a[0][j],ma[1]);
       for (int i=1;i<m-1;i++ ) {
          
          if(max>a[i][j])
          {
            sum+=(max-a[i][j]);            
           
          }
        max=Math.min(ma[i+1],a[i][j]);
        //System.out.println(sum+" "+max);

       }
        return sum;
  }
  int row_max(int[][] a,int i,int n){
     int max=0;
     for (int j=0;j<n ;j++ ) {
        max=Math.max(a[i][j],max);
     }
     return max;
  }
  int col_max(int[][] a,int j,int n){
     int max=0;
     for (int i=0;i<n ;i++ ) {
        max=Math.max(a[i][j],max);
     }
     return max;
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