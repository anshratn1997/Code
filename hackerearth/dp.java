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
    static int[] a=null;
    static int[][] dp=null;
    static int[] cumm=null;
    static boolean[] prime=new boolean[5001];

    // .......static class
  static class Pair{
      int key,value;
      Pair(int key,int value){
        this.key=key;
        this.value=value;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
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
        PRIME();

        int n=ii();
        a=new int[n+1];
        String line=si();
        String ll[]=line.split(" ");
        for (int i=0;i<n;i++ ) {
          a[i+1]=Integer.parseInt(ll[i]);
        }
        a[0]=0;
        dp=new int[n+2][n+2];
        cumm=new int[n+1];
        cumm[0]=a[0];
        for (int i=1;i<=n ;i++ ) {
          cumm[i]=a[i]+cumm[i-1];
        }
        for (int i=1;i<=n ;i++ ) {
           for (int j=i+1;j<=n ;j++ ) {
              dp[i][j]=-1;
           }
           dp[i][i]=0;
           dp[i][0]=0;
           dp[0][i]=0;
           dp[i][n+1]=0;
        }
        out.println(find_max(1,n));
        // out.println(cumm[n]);


      

  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.

  int find_max(int l,int r){
    if(prime[r-l+1])
    {
      int max=cumm[r]-cumm[l-1];
      dp[l][r]=max;
      return max;
    }
    if(dp[l][r]!=-1)
      return dp[l][r];
    int max=0;
    for (int i=l;i<=r ;i++ ) {
        if(dp[l][i-1]!=-1 && dp[i+1][r]!=-1)
        {
          max=Math.max(max,dp[l][i-1]+dp[i+1][r]);
          continue;
        }
        int m1=0;
        if(dp[l][i-1]==-1)
               m1=find_max(l,i-1);
        else 
          m1=dp[l][i-1];
        int m2=0;
        if(dp[i+1][r]==-1)
          m2=find_max(i+1,r);
        else
          m2=dp[i+1][r];

        max=Math.max(max,m1+m2);
        
    }
    dp[l][r]=max;
    return max;
  }

   void PRIME(){
    Arrays.fill(prime,true);
    prime[0]=false;
    prime[1]=false;
    for (int p=2; p<5001; p++)
    {
        if (prime[p] == true)
        {
           
            for (int i=p*2; i<5001; i += p){
                
                   prime[i] = false;
                 }
 
        }
     }
     
     //System.out.println(count);
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