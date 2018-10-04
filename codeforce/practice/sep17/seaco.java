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
        int n=tt[0],m=tt[1];
        int[][] q=iim(m,3);
        int[][] ass=new int[n+1][m+1];
        for (int i=0;i<=n ;i++ ) {
          Arrays.fill(ass[i],0);
        }
        for (int i=1;i<=m ;i++ ){
          if(q[i][1]==1){
            for(int k=1;k<=n;k++){
                 if(k>=q[i][2] && k<=q[i][3]){
    
                      ass[k][i]=(ass[k][i-1]+1)%mod;
 
                 }
                 else 
                  ass[k][i]=(ass[k][i-1])%mod;
            }
          }
          else{
            
             for(int k=1;k<=n;k++){
                if(q[i][2]>1){
                  if(q[i][2]==q[i][3])
                  ass[k][i]=(ass[k][i-1]+ass[k][q[i][2]])%mod;
                  else{
                  ass[k][i]=(ass[k][i-1]+ass[k][q[i][3]])%mod;
                  int ttt=-ass[k][q[i][2]-1];
                  if(ttt<0)
                  ttt=ttt+mod;
                  ass[k][i]+=ttt;
                   ass[k][i]%=mod;}
                }
                else 
                   ass[k][i]=(ass[k][i-1]+ass[k][q[i][3]])%mod;
             }
                 
          }
        }
        for (int i=1;i<=n ;i++ ) {
           System.out.print(ass[i][m]+" ");
        }
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
        int a[][] = new int[n+1][m+1];
        for (int i=0;i<=n;i++ ) {
          Arrays.fill(a[i],0);
        }
        for (int i = 1; i <=n; i++) {
          int[] temp=iint();
          for (int j = 1; j <=m; j++) a[i][j] =temp[j-1];
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