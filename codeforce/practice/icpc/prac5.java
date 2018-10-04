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
    static ArrayList[] graph=null;
    static int[] path=null;


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
      t=ii();
      while(t-->0){

        //........solution start
        int tt[]=iint();
        int n=tt[0],s=tt[1],e=tt[2];
        graph=new ArrayList[n+1];
        path=new int[n+1];

        for (int i=0;i<n+1 ;i++ ) {
         graph[i]=new ArrayList<>();
        }
        ArrayList<String> num=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          num.add(si());
        }
        for (int i=0;i<n ;i++ ) {
          String tar=num.get(i);
          int[] d1=find(tar);
          
          for (int j=i+1;j<n ;j++ ) {
             
             int d2[]=find(num.get(j));
             int sum=0;
             for (int l=0;l<10;l++ ) {
               sum+=Math.min(d1[l],d2[l]);
             }
             if(sum==17)
             {
              int p=i+1,q=j+1;
              //System.out.println("kdf "+p+" "+q);
              graph[i+1].add(j+1);
              graph[j+1].add(i+1);
             }

          }

        }
        bfs(s,e,n);
        int start=s;
        int end=e;
        int ans=0;
         while(end!=start){
            ans++;

          if(path[end]==0)
          {
          break;
        }
        else{
          end=path[end];
         }
      }
      if(end!=start)
        System.out.println("-1");
      else
      System.out.println(ans);

        

        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  int[] find(String st){
    int[] d1=new int[10];
          for (int l=0;l<20 ;l++ ) {
             int ch=(int)st.charAt(l)-48;
             d1[ch]++;
          }
    return d1;
  }
  void bfs(int start,int end,int n){
       boolean visited[]=new boolean[n+1];  
       Arrays.fill(path,0);
       Queue<Integer> st=new LinkedList<>();
       st.add(start);
       visited[start]=true;
        while(!st.isEmpty()){
            int u=st.poll();   
            for(int i=0;i<graph[u].size();i++){
              int pq=(int)graph[u].get(i);
              int v=pq;
              if(!visited[v]){
                visited[v]=true;
                 st.add(v);
                  path[v]=u;
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