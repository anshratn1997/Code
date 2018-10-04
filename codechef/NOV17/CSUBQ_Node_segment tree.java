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
    static int max=1000001;
    static Node[] tree1=new Node[2*max];
    static Node[] tree2=new Node[2*max];
    static int[] a=null;

    // .......static class
  static class Node{
     long total;
     int len,left,right;
     Node(){
      total=0;len=0;left=0;right=0;
     }
     Node(int value){
      left=value;right=value;total=value;
      len=1;
     }
    long Total(){return total;}
     int Len(){return len;}
    int Left(){return left;}
    int Right(){return right;}

    void merge(Node l,Node r){
      total=l.Total()+r.Total();
      len=l.Len()+r.Len();
      total+=(l.Right()*1L*r.Left());
      left=l.Left();
      right=r.Right();
      if(l.Left() == l.Len()) left += r.Left();
      if(r.Right() == r.Len()) right += l.Right();

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
      //t=ii();
      while(t-->0){

        //........solution start
        int tt[]=iint();
        int n=tt[0],m=tt[1],L=tt[2],R=tt[3];
        a=new int[n];
        for (int i=0;i<n ;i++ ) {
          a[i]=1;
        }
        build1(1,0,n-1);
        build2(1,0,n-1);
        for (int i=0;i<m ;i++ ) {
            int temp[]=iint();
            if(temp[0]==1){
              if(temp[2]<=R)
              update1(1,0,n-1,temp[1]-1,1);
              else
              update1(1,0,n-1,temp[1]-1,0);


             if(temp[2]<=L)
              update2(1,0,n-1,temp[1]-1,1);
             else
              update2(1,0,n-1,temp[1]-1,0);

            }
            else{

               int l=temp[1],r=temp[2];
               l--;r--;
               Node one=query1(1,0,n-1,l,r);
               Node two=query2(1,0,n-1,l,r);
           //    System.out.println("here total "+one.Total()+" "+two.Total());
              out.println(one.Total()-two.Total());

            }
        }
        // for (int i=1;i<=9;i++ ) {
        //   Node ff=tree1[i];
        //     System.out.println(ff.Total()+" "+ff.Left()+" "+ff.Right()+" "+ff.Len()); 
        // }
        //  for (int i=1;i<=9;i++ ) {
        //   Node ff=tree2[i];
        //     System.out.println(ff.Total()+" "+ff.Left()+" "+ff.Right()+" "+ff.Len()); 
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


void build1(int id, int lo, int hi){
    if(lo == hi){
      tree1[id]=new Node(a[lo]);
      return;
    }
    int mid = (lo+hi)/2;
    build1(2*id,lo,mid);
    build1(2*id+1,mid+1,hi);
    Node fuck=new Node();
    fuck.merge(tree1[2*id],tree1[2*id+1]);
    tree1[id]=fuck;
  }
void build2(int id, int lo, int hi){
    if(lo == hi){
         tree2[id]=new Node(a[lo]);
      return;
    }
    int mid = (lo+hi)/2;
    build2(2*id,lo,mid);
    build2(2*id+1,mid+1,hi);
    Node fuck=new Node();
    fuck.merge(tree2[2*id],tree2[2*id+1]);
    tree2[id]=fuck;    
  }
void update1(int id, int lo, int hi, int pos, int val){
    if(lo==hi && lo==pos){
      a[pos] = val;
      tree1[id]=new Node(val);
      return;
    }
    int mid = (lo+hi)/2;
    if(pos <= mid) update1(2*id,lo,mid, pos, val);
    else update1(2*id+1,mid+1,hi, pos, val);
    Node fuck=new Node();
    fuck.merge(tree1[2*id],tree1[2*id+1]);
    tree1[id]=fuck;
  }
  void update2(int id, int lo, int hi, int pos, int val){
    if(lo==hi && lo==pos){
      a[pos] = val;
      tree2[id]=new Node(val);
      return;
    }
    int mid = (lo+hi)/2;
    if(pos <= mid) update2(2*id,lo,mid, pos, val);
    else update2(2*id+1,mid+1,hi, pos, val);
    Node fuck=new Node();
    fuck.merge(tree2[2*id],tree2[2*id+1]);
    tree2[id]=fuck;
  }
  Node query1(int id, int lo, int hi, int x, int y){
    if(lo==x && hi==y){
      return tree1[id];
    }
    int  mid = (lo+hi)/2;
    if(y <= mid) return query1(2*id,lo,mid, x, y);
    else if(x>mid) return query1(2*id+1,mid+1,hi, x, y);
    Node Ln = query1(2*id,lo,mid, x, mid);
    Node Rn = query1(2*id+1,mid+1,hi, mid+1, y);
    Node res=new Node();
    res.merge(Ln,Rn);
    return res;
  }
  Node query2(int id, int lo, int hi, int x, int y){
    if(lo==x && hi==y){
      return tree2[id];
    }
    int mid = (lo+hi)/2;
    if(y <= mid) return query2(2*id,lo,mid, x, y);
    else if(x>mid) return query2(2*id+1,mid+1,hi, x, y);
    Node Ln = query2(2*id,lo,mid, x, mid);
    Node Rn = query2(2*id+1,mid+1,hi, mid+1, y);
    Node res=new Node();
    res.merge(Ln,Rn);
    return res;
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