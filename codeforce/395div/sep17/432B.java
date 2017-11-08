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
    static List<Integer> a=new ArrayList<>();
      static List<Integer> b=new ArrayList<>();
      static int[][] p=null;
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
       int n=ii();
       p=iim(n,5);
       //List<Integer> a=new ArrayList<>();
       //List<Integer> b=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
        for (int k=0;k<n ;k++ ) {
            if(calculate(i,k))
              a.add(i);b.add(k);
        }
       }
       List<Integer> ans=new ArrayList<>();/*
       for (int i=0;i<n ;i++ ) {
          for (int k=0;k<a.size() ;k++ ) {
              
                if(calculate(i,a.get(k)) && calculate(i,b.get(k))){
                  ans.add(i);
                  break;
                
              }
          }
       }*/
       for (int i=0;i<a.size() ;i++ ) {
           for (int k=0;k<b.size() ;k++ ) {
               if(a.get(k)==a.get(i) || b.get(k)==b.get(i) || a.get(k)==b.get(i) || b.get(k)==b.get(i))
               {
                  if(a.get(k)==a.get(i) || b.get(k)==b.get(i))
                    ans.add(a.get(i));
                  else
                    ans.add(b.get(i));
                  break;
               }
           }
       }
       Collections.sort(ans);
       for (int i=0;i<ans.size() ;i++ ) {
          System.out.print(ans.get(i)+1);
       }



     }
     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  boolean  calculate(int i,int j){
     int nume=p[i][0]*p[j][0]+p[i][1]*p[j][1]+p[i][2]*p[j][2]+p[i][3]*p[j][3]+p[i][4]*p[j][4];
     double denom=Math.sqrt(p[i][0]*p[i][0]+p[i][1]*p[i][1]+p[i][2]*p[i][2]+p[i][3]*p[i][3]+p[i][4]*p[i][4]);
     denom=denom*Math.sqrt(p[j][0]*p[j][0]+p[j][1]*p[j][1]+p[j][2]*p[j][2]+p[j][3]*p[j][3]+p[j][4]*p[j][4]);
     double ff=180.0;
      double fuck=(Math.acos((nume*1.00)/(denom*1.0))*ff)/pi;
      double l=0.0,up=90.0;
     if(fuck>=up && fuck<180.0)
       return false;
     else
      return true;
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