import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Spiral{
    
    static int max=1000001;
    
    static boolean prime[]=new boolean[max];
    ArrayList<Integer> primelist=new ArrayList<>();
   
    BufferedReader br;
    public static void main(String[] args) {
    new Spiral().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     int temp[]=iint();

      
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  
  void dfs(char[][] forest.int x,int y){
       Queue<Map.Entry > st=new LinkedList<>();
        
       st.add(new AbstractMap.SimpleEntry(x,y));
        while(!st.isEmpty()){
            Map.Entry pq=st.poll();
            
        
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


    