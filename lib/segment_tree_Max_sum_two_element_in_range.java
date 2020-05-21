

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
   static Node[] tree=null;
   static int[] arr=null;

   // .......static class
 static class Node{
     int key,value;
     Node(int key,int value){
       this.key=key;
       this.value=value;
     }
     int f(){
       return key;
     }
     int s(){
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
     while(t-->0){

       //.
       // .......solution start
     
    int n=ii();
    arr = iint();
    int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
    int max_size = 2 * (int) Math.pow(2, x) - 1;
         tree = new Node[4*max_size]; 
         
         construct(1, 0, n-1);
         int q=ii();
         // for(int i=1;i<10;i++){
         //  out.println(tree[i].f()+" nn "+tree[i].s());
         // }
         for(int i=0;i<q;i++){
                String qq[]=si().split(" ");
                if(qq[0].charAt(0) == 'U'){
                int idx=Integer.parseInt(qq[1]);
                idx--;
                int value=Integer.parseInt(qq[2]);
                update(1, 0, n-1, idx, value);
                }
                else{
                int idx1=Integer.parseInt(qq[1]);
                idx1--;
                int idx2=Integer.parseInt(qq[2]);
                idx2--;
                Node pp=query(1, 0, n-1, idx1, idx2);
                 // out.println(pp.f()+" "+pp.s());
                 out.println(pp.f()+pp.s());
               
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
 // int max_2(int a,int b,int c,int d){
 //    int res=Math
 // }

 void construct(int node, int start, int end){
 
      if(start==end){
     
      tree[node]=new Node(arr[start],0);
       
      }
      else{
       int mid=(start+end)/2;
       construct(2*node, start, mid);
       construct(2*node+1, mid+1,end);
       int[] al=new int[4];
       
       al[0]=tree[2*node+1].f();
       al[1]=tree[2*node+1].s();
       al[2]=tree[2*node].f();
       al[3]=tree[2*node].s();
       Arrays.sort(al);
       tree[node]=new Node(al[3],al[2]);
      
 
      }
 }
 
 void update(int node,int start, int end,int idx,int value){
    if(start == end){
       arr[idx]=value;
    tree[node]=new Node(arr[idx],0);
    }
   else{
       int mid = (start + end) / 2;
       if(start <= idx && idx <= mid)
       {
        
           update(2*node, start, mid, idx, value);
       }
       else
       {
           update(2*node+1, mid+1, end, idx, value);
       }
       
       int[] al=new int[4];
       al[0]=tree[2*node+1].f();
       al[1]=tree[2*node+1].s();
       al[2]=tree[2*node].f();
       al[3]=tree[2*node].s();
       Arrays.sort(al);
       tree[node]=new Node(al[3],al[2]);
   }
}
 Node query(int node, int start, int end, int l, int r)
 {

     if(r < start  ||  end < l)
     {      
         Node deflt=new Node(0,0);
         // out.println("state "+node+" "+start+" "+end+" "+deflt.f()+" "+deflt.s());
         return deflt;
     }
     if(l <= start && end <= r)
     {
        // out.println("state "+node+" "+start+" "+end+" "+tree[node].f()+" "+tree[node].s());
         return tree[node];
     }

     int mid = (start + end) / 2;
     Node p1 = query(2*node, start, mid, l, r);
     Node p2 = query(2*node+1, mid+1, end, l, r);
       int[] al=new int[4];
       al[0]=p1.f();
       al[1]=p1.s();
       al[2]=p2.f();
       al[3]=p2.s();
       Arrays.sort(al);
      Node ret=new  Node(al[3],al[2]);

    // out.println("state "+node+" "+start+" "+end+" "+ret.f()+" "+ret.s());
     return ret;

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