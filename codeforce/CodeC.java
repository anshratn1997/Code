import java.io.*;
import java.util.*;
import java.math.*;
// public 
class Main{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    static int[] a=null;
    static int[] b=null;
    static int[] tree1=new int[4*1000001];
    static int[] tree2=new int[4*1000001];


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

        int n=ii();
        a = iint();
        b = iint();
        
        Arrays.sort(a);
        Arrays.sort(b);
        build1(1,0,n-1);
        build2(1,0,n-1);
      int move = 1;
      int A=0,B=0;
      int i=n,j=n;
      while(i+j != 0 ){
         if(move == 1){
            if(j==0){
              int maxa = query1(1,0,n-1,0,i-1);
              A+=maxa;
              i--;
            }
            else if(i==0){
              j--;
            }
            else{
               int maxa=query1(1,0,n-1,0,i-1);
               int maxb=query2(1,0,n-1,0,j-1); 
               if((A+maxa-B )> (A-B)){
                 A+=maxa;
                 i--;
               }
               else{
                j--;
               }
            }
          move =2;

         }
         else{
            if(i==0){
              int maxb =query2(1,0,n-1,0,j-1);
              B+=maxb;
              j--;
            }
            else if(j==0){
              i--;
            }
            else{
               int maxa=query1(1,0,n-1,0,i-1);
               int maxb=query2(1,0,n-1,0,j-1); 
               if(B+maxb-A > B-A){
                 B+=maxb;
                 j--;
               }
               else{
                i--;
               }
            }
          move =1;

         }
      }
      System.out.println(A-B);



      

  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  void build1(int node, int start, int end)
{
    if(start == end)
    {
        // Leaf node will have a single element
        tree1[node] = a[start];
    }
    else
    {
        int mid = (start + end) / 2;
        // Recurse on the left child
        build1(2*node, start, mid);
        // Recurse on the right child
        build1(2*node+1, mid+1, end);
        // Internal node will have the sum of both of its children
        tree1[node] = Math.max(tree1[2*node] ,tree1[2*node+1]);
    }
}
  void build2(int node, int start, int end)
{
    if(start == end)
    {
        // Leaf node will have a single element
        tree2[node] = b[start];
    }
    else
    {
        int mid = (start + end) / 2;
        // Recurse on the left child
        build2(2*node, start, mid);
        // Recurse on the right child
        build2(2*node+1, mid+1, end);
        // Internal node will have the sum of both of its children
        tree2[node] = Math.max(tree2[2*node] ,tree2[2*node+1]);
    }
}
int query1(int node, int start, int end, int l, int r)
{
    if(r < start || end < l)
    {
        // range represented by a node is completely outside the given range
        return 0;
    }
    if(l <= start && end <= r)
    {
        // range represented by a node is completely inside the given range
        return tree1[node];
    }
    // range represented by a node is partially inside and partially outside the given range
    int mid = (start + end) / 2;
    int p1 = query1(2*node, start, mid, l, r);
    int p2 = query1(2*node+1, mid+1, end, l, r);
    return Math.max(p1,p2);
}
int query2(int node, int start, int end, int l, int r)
{
    if(r < start || end < l)
    {
        // range represented by a node is completely outside the given range
        return 0;
    }
    if(l <= start && end <= r)
    {
        // range represented by a node is completely inside the given range
        return tree2[node];
    }
    // range represented by a node is partially inside and partially outside the given range
    int mid = (start + end) / 2;
    int p1 = query2(2*node, start, mid, l, r);
    int p2 = query2(2*node+1, mid+1, end, l, r);
    return Math.max(p1,p2);
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