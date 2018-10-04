import java.io.*;
import java.util.*;
import java.math.*;
//public 
class icpc1{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    
 
    // .......static class
  static class Pair{
      int key,value,wait;
      Pair(int key,int value,int wait){
        this.key=key;
        this.value=value;
        this.wait=wait;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
      }
      int Wait(){
        return wait;
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
    new icpc1().main1();
 
  }
  void main1()
  {
    try{
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
        int t=1;
        //t=ii();
         while(t-->0){
 
        //........solution start
          double tt[]=idouble();
          double n=tt[0],k=tt[1];

         
          double ll=-100000000*1.0;
          double rr=100000000.0*1.0;
          double find=1.0*Math.pow(n,3)*Math.pow(k,2);
          System.out.println(find);
           double mid=1.0;
        while(ll<rr){
           mid=(ll+rr)/2;
           double c=calc(mid,n);
           if(c==find)
             {
              System.out.println(c);
              break;
             }
          else if(mid>find){
             rr=mid-1;
          }
          else
            ll=mid+1;

        }

         if((int)n==1){
           if((int)k==0)
           System.out.println("0");
           else
            System.out.println("-1");
         }
         else{
          for (int i=0;i<n-1 ;i++ ) {
            System.out.print("0 ");
          }
          System.out.println(mid/(double)Math.pow(n,2));}

         



          

        
 
 
 
 
        
 
  
 
       //..........solution end.
 
     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }
 
 
  // ...............required method.

 double calc(double u,double n){
  double rt=(n-1.0)*Math.pow(u,2)+Math.pow(3*u-u,2);
  return rt;
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


