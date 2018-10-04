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
    static final int size=1000;
    static int store[][]=new int[size+1][size+1];
    static int dp[][]=new int[size+1][size+1];
    static HashMap[] count=new HashMap[size+1];
    static int bucket[]=null;
    static int local[]=null;
    static int end[]=null;


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

        //........solution start
        int[] nq=iint();
        int n=nq[0],q=nq[1];
        int[] a=iint();
        bucket=new int[n];
        local=new int[n];
        end=new int[size+1];
        for (int i=0;i<=size ;i++ ) {
          count[i]=new HashMap<Integer,Integer>();
        }
        int _i=0,b=-1;
        for (int i=0;i<n;i++ ) {
            if(i%size==0){
               if(b>=0)
                 make_dp(b);
               b++;_i=0;
            }
            store[b][_i]=a[i];
            bucket[i]=b;
            local[i]=_i;
            end[b]=_i;
            _i++;


        }  
        make_dp(b);
        for (int i=0;i<q ;i++ ) {
                int qq[]=iint();
                if(qq[0]==1){
                  int bb=bucket[qq[1]-1];
                  int ind=local[qq[1]-1];
                  store[bb][ind]=qq[2];
                  make_dp(bb);
                }
                else
                {
                  int ans=0,pre=0,ind=0;
                  int bb=bucket[qq[1]-1];
                  while(bucket[ind]<bb){
                    int curr=bucket[ind];
                    int need=qq[2]^pre;
                    if(count[curr].containsKey(need))
                     ans+=(int)count[curr].get(need);

                    pre^=dp[curr][end[curr]];
                    ind+=size;
                    
                  }
                  for (int j=0;j<=local[qq[1]-1] ;j++ ) {
                    pre^=store[bb][j];
                    // System.out.println("ub "+pre);
                    if(pre==qq[2])
                      ans++;
                  }
                  out.println(ans);
                }
         }
        //   for (int i=0;i<n ; i++) {
        //   System.out.println(store[0][i]+" "+dp[0][i]);
        // }
        // System.out.println("count "+count[0].get(2));






      
        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  void make_dp(int b){
     int sz=end[b];
     count[b].clear();
     dp[b][0]=store[b][0];
     for (int i=1;i<=sz ;i++ ) {
       dp[b][i]=store[b][i]^dp[b][i-1];
     }
     for (int i=0;i<=sz ;i++ ) {
          if(count[b].containsKey(dp[b][i])){
          int value=(int)count[b].get(dp[b][i]);
          value++;
        count[b].put(dp[b][i],value);}
        else
          count[b].put(dp[b][i],1);
     }
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