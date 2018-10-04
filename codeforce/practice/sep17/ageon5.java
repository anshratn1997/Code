import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
  static class Pair
  {
         long key;
         long value;
        Pair(long key,long value){
          this.key=key;
          this.value=value;
        }
        public long getKey(){
          return key;
        }
        public long getValue(){
          return value;
        }
  }

 BufferedReader br;
 static List graph[]=null;

  static boolean visited[]=null;
  static long ver=0,edge=0;
   //TreeMap<Integer,Integer> tm=new TreeMap<>();
   ArrayList<Pair> vegdge=new ArrayList<>();
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      int t=1;
     // t=ii();
      while(t-->0){
        int temp[]=iint();
        int n=temp[0];int m=temp[1];
       graph =new ArrayList[n+1];
       visited=new boolean[n+1];
       Arrays.fill(visited,false);
       for (int i=0;i<=n ;i++ ){graph[i]=new ArrayList<Integer>();}
       for (int i=0;i<m ;i++ ) {
           long temp1[]=ilong();
           graph[(int)temp1[0]].add(temp1[1]);
           graph[(int)temp1[1]].add(temp1[0]);
               
       }
       count_v_edge(n);
       Collections.sort(vegdge,new Comparator<Pair>() {
    @Override
    public int compare(Pair a1, Pair a2) {
     Long o1=a1.getValue(),o2=a2.getValue();
         return o1.compareTo(o2);
     }
  });
       Set<Integer> set=new HashSet<>();
       int ct=0;
       long ans=0L;
       for(int i=0;i<vegdge.size();i++)
      {

          Pair pq=vegdge.get(i);
          long v=pq.getKey();long e=pq.getValue();
           ans=ans+v*(v-1);
         // System.out.println(pq.getKey()+" "+pq.getValue());}
           long diff=e-v;
          if(diff>=0 && ct<2){
               if(diff==0)
               {
                ct++;
                set.add(i);
               }
               else{
                set.clear();
                set.add(i);
                ct=2;
               }
          }
      }
     // System.out.println("df "+ct);
     if(ct==1){
      for(int i=0;i<vegdge.size();i++){
         Pair pq=vegdge.get(i);
        long v=pq.getKey();
        if(!set.contains(i)){
       ans=ans-((v-1)*2);
        break;}
     }}
     else if(ct==0){
      int c=0;
       for(int i=0;i<vegdge.size();i++){
         if(c==2)
          break;
         Pair pq=vegdge.get(i);
        long v=pq.getKey();long e=pq.getValue();
        if(!set.contains(i) && c<2){
           if(e>=2 && c==0){
           ans=ans-(2*((2*v)-3));
           c=2;
         }else{ans=ans-(2*(v-1));c++;}

           }
       }
    }
     
     System.out.println(ans);
     }
     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  void count_v_edge(int n){
     for(int i=1;i<=n;i++)
     {
        if(!visited[i]){
          dfs(i);
          vegdge.add(new Pair(ver,edge/2));
          ver=0;edge=0;
        }
        
     }
  }
  
void dfs(int u){
    visited[u]=true;
    ver++;
    for(int i=0;i<graph[u].size();i++)
     {  edge++;
         long v=graph[u].get(i);
         if(!visited[(long)v]){

          dfs(v);
         }         
     }
}
  
  
   //input method
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
    String[] isa(int n) {
        String a[] =si().split(" ");
        return a;
    }

    double[][] idm(int n, int m) {
        double a[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
          double[] temp=idouble();
          for (int j = 0; j < m; j++) a[i][j] = temp[j];
        }
        return a;
    }

    int[][] iim(int n, int m) {
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
          int[] temp=iint();
          for (int j = 0; j < m; j++) a[i][j] =temp[j];
        }
        return a;
    }
    long[][] ilm(int n, int m) {
       long a[][] = new long[n][m];
        for (int i = 0; i < n; i++) {
          long[] temp=ilong();
          for (int j = 0; j < m; j++) a[i][j] =temp[j];
        }
        return a;
    }
    
} 