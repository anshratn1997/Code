import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
  /*
  static class Graph{
    List graph[];
     public Graph(int vertices){
        graph=new ArrayList[vertices+1];
       }
        for (int i=0;i<=n ;i++ ) {
           graph[i]=new ArrayList<Pair<Long,Long> >();
        }
        public addedge(long u,long v,long w)
        {
            graph[(int)u].add(new Pair(v,c));
        }

  }*/
 
 BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      
        int t=ii();
        while(t-->0){
          int n=ii();
          int temp[]=iint();
          int ans=0;
          for (int i=0;i<n ;i++ ) {
            ans=ans|temp[i];
          }
          System.out.println(ans);
        }

 
    
  }
    catch(Exception e){
        e.printStackTrace();}
    
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

    
} 