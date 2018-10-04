import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main1{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;

  static List graph[]=null;
  static boolean visited[]=null;
  static boolean find=false;
static  StringBuffer sb=null;

    // .......static classs
  
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new Main1().main1();
 
  }
  void main1()
  {
    try{
     //br=new BufferedReader(new InputStreamReader(System.in));
     br=new BufferedReader(new FileReader(new File("input.txt")));
     out=new PrintWriter("output.txt");
      int t=1;
      t=ii();

      while(t-->0){


        //...............solution start here
        
       int[] line1=iint();
       int n=line1[0],m=line1[1];
       sb=new StringBuffer(" ");
       sb.append(br.readLine());
       boolean ans=true;
       graph =new ArrayList[n+1];
       visited=new boolean[n+1];
       Arrays.fill(visited,false);
      for (int i=0;i<=n ;i++ ){graph[i]=new ArrayList<Integer>();}
      int[][] q=new int[m][2];
       for (int i=0;i<m;i++ ) {
           int tt[]=iint();
           int x=tt[0],y=tt[1];
           graph[x].add(y);
           graph[y].add(x);    
        }
      for(int i=1;i<=n;i++){
        if(!visited[i])
          dfs(i);
      }
      int ff=0;
      for (int i=0;i<=n ;i++ ) {
        if(sb.charAt(i)=='?')
          ff+=26;

      }
      System.out.println(ff);



    System.out.println(ans);
      
      //.................solution end here.

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
    Character c=null;
    for(int i=0;i<graph[u].size();i++)
     {  
         int v=(int)graph[u].get(i);
         if(!visited[v] && !find){
            if(sb.charAt(v)!='?')
              dfs(v);
         }
         else{
            if(sb.charAt(v)!='?')
              {find=true;c=sb.charAt(v);}
         }
               
     }
     if(find && c!=null){
      sb.deleteCharAt(u);
      sb.replace(u,u,c.toString());
   }
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