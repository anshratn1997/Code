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
    static int[][] dp=null;
    static  ArrayList<Integer> av=null;
   
    static int n=0;
    static ArrayList[] ts=new ArrayList[101];
    static int N=0;

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
         n=ii();
        ArrayList[] gp=new ArrayList[n];
        N=(int)Math.pow(2,n);
        dp=new int[N][101];

       
        for (int i=0;i<N ;i++) {
          Arrays.fill(dp[i],-1);
        }
        for (int i=0;i<n ;i++ ) {
             int[] line=iint();
            gp[i]=new ArrayList<>();
            for (int j=0;j<line.length ;j++ ) {
               gp[i].add(line[j]);
            }
        }

        for (int i=1;i<101 ;i++ ) {  
        ts[i]=new ArrayList<>();
      }
     
      for (int i=0;i<n ;i++ ) {
         for (int j=0;j<gp[i].size() ;j++ ) {   
           ts[(int)gp[i].get(j)].add(i+1);
         }
      }
      System.out.println(findpath(0,new HashSet<Integer>()));


      

  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  int findpath(int mask,HashSet<Integer> set){

     int ret=0;
     if(mask==N-1)
      return 1;
   
      for(int i=0;i<av.size();i++ ) {
           int tsnum=av.get(i);
         if(set.contains(tsnum))
          continue;
         for (int j=0;j<ts[tsnum].size() ;j++ ) {
             if((mask & (1 << (int)ts[tsnum].get(j)))==0){
             if(v[(mask | 1 << (int)ts[tsnum].get(j))][tsnum]){
               ret+=dp[(mask | 1 << (int)ts[tsnum].get(j))][tsnum];

             }
             else{
              set.add(tsnum);
              ret+=findpath(mask | 1 << (int)ts[tsnum].get(j),set);
              v[(mask | 1 << (int)ts[tsnum].get(j))][tsnum]=true;
             }
               
          }

       }
   }

   return ret;


  }
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