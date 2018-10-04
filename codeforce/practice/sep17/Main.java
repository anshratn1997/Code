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
    static Object[] tree=new Object[100001];
    int a[]=null;

    // .......static class
  static class Pair{
      int key,value;
      Pair(int key,int value){
        this.key=key;
        this.value=value;
      }
      int mn(){
        return Math.min(key,value);
      }
      int mx(){
        return Math.max(key,value);
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
      t=ii();
      while(t-->0){

        //........solution start
        int n=ii();
         a=iint();
         bulid(1,0,n-1,0,n-1);


        
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.


    void bulid(int ind,int st,int end,int qs,int qe){
      if(st<qs || end< qe)
        return;

      if(a==b){
        tree[ind]=new Pair(a[st],a[end]);
        return;
      }
      int mid=(a+b)/2;
      bulid(2*ind,a,mid);
      bulid(2*ind+1,mid+1,b);
      int min=tree[2*ind].mn();
      int max=tree[2*ind+1].mx();
      tree[ind]=new Pair(min,max);
    }
    Pair query(int ind,int st,int end,int l,int r,int qs,int qe){
           if(qs>st || qe<end )
              return null;
            if(st>=l && end<=r)
            {
              return tree[ind];
            }
          int mid=(st+end)/2;
          Pair p1=query(2*ind,st,mid,l,r,qs,qe);
          Pair p2=query(2*ind+1,mid+1,mid,l,r,qs,qe);
          int max=Math.max(p1.mx(),p2.mx());
          int min=Math.min(p1.mn(),p1.mn());
          return new Pair(min,max);

    }



  //................end.
  
  
   //..............input method start. 
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