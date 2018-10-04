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
    static ArrayList<Pair> al=new ArrayList<>();
    static long tree[]=new long[5*100001];
    long ans[]=null;

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
        int[] w=iint();
        int l[]=iint();
        int[] r=iint();
        
         ans=new long[n+1];
        for (int i=0;i<n ;i++ ) {
          int lt=i-l[i]-1;
          al.add(new Pair(lt,i));
        }
        Collections.sort(al,new mycomparator());
        for (int i=0;i<n ;i++ ) {
          ans[i]=w[i];
        }
        build(1,0,n-1);

        ans[n-1]=w[n-1];
        long max=w[n-1];
        Pair pq=al.get(n-1);
        for (int i=n-2;i>=0 ;i-- ) {
          Pair p=al.get(i);
          ans[i]=w[i];
          int right=i+r[i]+1;
          int ind_up=upperBound(n,i+right);
          int ind_low=upperBound(n,i-1);
          long lm=query(1,0,n-1,ind_low,Math.min(ind_up,n-1));
    
          System.out.println(lm);
          ans[i]=Math.max(lm+ans[i],ans[i]);

          update(1,0,n-1,i,ans[i]);

        }
       
        for (int i=0;i<n ;i++ ) {
          System.out.print(ans[i]+" ");
         max=Math.max(max,ans[i]);
        }
        System.out.println(max);

              
         


  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
void build(int node, int start, int end)
{
    if(start == end)
    {
        // Leaf node will have a single element
      //System.out.println("start "+start);
      Pair pp=al.get(start);

        tree[node] = ans[pp.Value()];
    }
    else
    {
        int mid = (start + end) / 2;
        // Recurse on the left child
        build(2*node, start, mid);
        // Recurse on the right child
        build(2*node+1, mid+1, end);
        // Internal node will have the sum of both of its children
        tree[node] = Math.max(tree[2*node],tree[2*node+1]);
    }
}
void update(int node, int start, int end, int idx, long val)
{
    if(start == end)
    {
        // Leaf node
        Pair pp=al.get(start);
        System.out.println("start and value "+start+" "+pp.Value());
        tree[node]=ans[pp.Value()];
    }
    else
    {
        int mid = (start + end) / 2;
        if(start <= idx && idx <= mid)
        {
            // If idx is in the left child, recurse on the left child
            update(2*node, start, mid, idx, val);
        }
        else
        {
            // if idx is in the right child, recurse on the right child
            update(2*node+1, mid+1, end, idx, val);
        }
        // Internal node will have the sum of both of its children
        tree[node] = Math.max(tree[2*node],tree[2*node+1]);
    }
}
long query(int node, int start, int end, int l, int r)
{
    if(r < start || end < l)
    {
        // range represented by a node is completely outside the given range
        return 0;
    }
    if(l <= start && end <= r)
    {
        // range represented by a node is completely inside the given range
        return tree[node];
    }
    // range represented by a node is partially inside and partially outside the given range
    int mid = (start + end) / 2;
    long p1 = query(2*node, start, mid, l, r);
    long p2 = query(2*node+1, mid+1, end, l, r);
    return Math.max(p1,p2);
}

public  int upperBound(int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            Pair p=al.get(mid);
            if (value >=p.Key()) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
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