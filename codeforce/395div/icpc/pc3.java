import java.io.*;
import java.util.*;
import java.math.*;
//public 
class pc3{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
     static ArrayList[] graph=null;
     boolean visited[]=null;
     static int path[]=null;
     static long[] sum=null;
  
     static int[] arr=null;

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
    new pc3().main1();
 
  }
  void main1()
  {
    try{
      //  if (System.getProperty("ONLINE_JUDGE") == null) {
        // Input is a file
       // br=new BufferedReader(new FileReader(new File("in.txt")));
       // out=new PrintWriter("out.txt");
       //} else {
        // Input is System.in
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
      //}
      int t=1;
      //t=ii();
      while(t-->0){

        //........solution start
       int line[]=iint();
       int n=line[0],m=line[1];
       arr=iint();
       path=new int[n+1];
       graph=new ArrayList[n+1];
       sum=new long[n+1];
       visited=new boolean[n+1];
       Arrays.fill(visited,false);
       for (int i=0;i<=n ;i++ ) {
           graph[i]=new ArrayList<Integer>();
        }
       for (int i=0;i<n-1 ;i++ ) {
           int temp[]=iint();
           graph[temp[0]].add(temp[1]);
           graph[temp[1]].add(temp[0]);           
       }
       dfs(1);
        
         
        for (int i=0;i<m ;i++ ) {
          String ll=si();
          if(ll.charAt(0)=='Q'){
            char ch=ll.charAt(2);
            int ind=(int)ch-48;
            //System.out.println(ind);
            out.println(sum[ind]);             
          }
          if(ll.charAt(0)=='U'){
            int ind=(int)ll.charAt(2)-48;
             int v=(int)ll.charAt(4)-48;
             int diff=v-arr[ind-1];
             sum[ind]+=diff;
             int start=1,end=ind;
             while(end!=start){
              if(path[end]==0)
                break;
              end=path[end];
              sum[end]+=diff;
             }
             
          }

        }
        
       








        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  void dfs(int u){
    visited[u]=true;
    long tt=0;
    for(int i=0;i<graph[u].size();i++)
     {  
         int v=(int)graph[u].get(i);

         if(!visited[v]){
         
          path[v]=u;
          dfs(v);
          tt=tt+sum[v];
         }         
     }
     //out.println(tt+" "+u);
     sum[u]=tt+arr[u-1];
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