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
    static NavigableSet[] graph=null;
    

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

        int nq[]=iint();
        int n=nq[0],q=nq[1];
        int[] a=iint();
        //HashSet<Integer> set=new HashSet<>();
        graph=new NavigableSet[200001];
        for (int i=0;i<200001 ;i++ ) {
          graph[i]=new TreeSet<Integer>();
        }
        for (int i=0;i<n ;i++ ) {
          graph[a[i]].add(i);
        }
        
        // System.out.println(graph[1].ceiling(6));
        
        
      

       while(q-->0){
            String qq[]=isa();
            int y=Integer.parseInt(qq[0]);
            int z=Integer.parseInt(qq[1]);
            char ch=qq[2].charAt(0);
            if(graph[z].size()==0){
              out.println("-1");
              continue;
            }
            if(ch=='L')
            { 
              //System.out.println(y+" "+store[z][0]);
             Integer x=(Integer)graph[z].floor(y);
             if(x==null)
              x=(Integer)graph[z].last();
             // out.println("hello "+x);
             if(y>x){

                out.println(y-x);
             }
              else if(y==x)
                out.println("0");
              else
                out.println(n-(x-y));
             

            }
            if(ch=='R')
            { 
              Integer x=(Integer)graph[z].ceiling(y);
             if(x==null)
              x=(Integer)graph[z].first();
              // out.println("hello 1 "+x);
               if(y>x)
                out.println(n-(y-x));
              else if(y==x)
                out.println("0");
              else
             { 
                out.println(x-y);
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
    String[] isa() throws IOException{
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