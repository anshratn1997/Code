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
    static boolean visit[][]=null;
   
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
   // static ArrayList[] graph=null;
    static ArrayList<Pair> al=null; 
    static int[][] arr=null;
    


    // .......static class
  static class Pair{
      int key,ii,jj;
      Pair(int key,int ii,int jj){
        this.key=key;
        this.ii=ii;
        this.jj=jj;
      }
      int Key(){
        return key;
      }
      int XX(){
        return ii;
      }
      int YY(){return jj;}
  }
static class Pair1{
      int key,value;
      Pair1(int key,int value){
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
    public static void main(String[] args){
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

        //.
        // .......solution start
        int[] tt=iint();
        int n=tt[0],m=tt[1];
        visit=new boolean[n][m];
        for (int i=0;i<n ;i++ ) {
          Arrays.fill(visit[i],false);
        }
        arr=iim(n,m);
        // arr=new int[n][m];
        // for (int i=0;i<n; i++) {
        //   for (int j=0;j<m ;j++ ) {
        //      arr[i][j]=1;
        //   }
        // }
        int ct=0;
        al=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
           for (int j=0;j<m ;j++ ) {
              al.add(new Pair(arr[i][j],i,j));
           }
        }
        Collections.sort(al,new mycomparator());
     
        for (int i=n*m-1;i>=0 ;i-- ) {
           Pair p=al.get(i);
           int x=p.XX();
           int y=p.YY();

           if(!visit[x][y])
             {
                ct++;

                bfs(x,y,n,m);

             }

        }
        out.println(ct);



    
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  boolean valid(int i,int j,int n,int m){
    if(i<n && i>=0 && j<m && j>=0)
      return true;
    return false;
  }
  boolean move(int x1,int y1,int x2,int y2){
     if(arr[x1][y1]>=arr[x2][y2])
       return true;
     return false;

  }

  void bfs(int i,int j,int n,int m){
     Queue<Pair1> q=new LinkedList<>();
     q.add(new Pair1(i,j));
     visit[i][j]=true;
     while(!q.isEmpty()){
       Pair1 pin=q.peek();
       q.poll();
       int x1=pin.Key(),y1=pin.Value();
       for (int l=0;l<4 ;l++ ) {
          int x2=x1+dx[l],y2=y1+dy[l];
          if(valid(x2,y2,n,m)){
             if(move(x1,y1,x2,y2)){
                if(!visit[x2][y2]){
                visit[x2][y2]=true;
                 //System.out.println("x and y "+x2+" "+y2); 
                q.add(new Pair1(x2,y2));
                }
              }
          }
       }
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