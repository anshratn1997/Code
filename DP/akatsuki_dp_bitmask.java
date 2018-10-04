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
  static class Pair{
      int key,value;
      Pair(int key,int value){
        this.key=key;
        this.value=value;
      }
      int X(){
        return key;
      }
      int Y(){
        return value;
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
      int t=1;
     // t=ii();

       assert t==1 : "gadkjfk";
      while(t-->0){

        //........solution start
        int n=ii();
        ArrayList<Pair> al1=new ArrayList<>();
        ArrayList<Pair> al2=new ArrayList<>();
        // al1.add(new Pair(100,100));
        for (int i=0;i<n ;i++ ) {
          int tt[]=iint();
          al1.add(new Pair(tt[0],tt[1]));

        }
        // al2.add(new Pair(100,100));
        
        for (int i=0;i<n ;i++ ) {
          int tt[]=iint();
          al2.add(new Pair(tt[0],tt[1]));

        }

        int N=(int)Math.pow(2,n);
        long[] dp=new long[N];
        for (int i=0;i<N ;i++ ) {
          dp[i]=inf;
        }
        dp[0]=0;
        for (int mask=0;mask<N ;mask++ ) {
          int i=countSetBits(mask);

          for (int j=0;j<n;j++ ) {
          
            if( (mask & (1 << j))==0 ) 
               { 
                int diff=Math.abs(al1.get(i).X()-al2.get(j).X())+Math.abs(al1.get(i).Y()-al2.get(j).Y());
              
                dp[ mask | (1 << j)]=Math.min(dp[mask | (1 << j)],dp[mask]+diff);

              }  
            }     
        }
         System.out.println(dp[N-1]);
        // for (int i=0;i<N ;i++ ) {
        // System.out.println(dp[i]);
        // }

      

  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.

int countSetBits(int n){
  int count = 0;
  while (n>0)
  {
    count += n & 1;
    n >>= 1;
  }
  return count;
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