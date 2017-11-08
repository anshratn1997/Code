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
 static List graph[]=new ArrayList[100003];
// static long dic[]=new long[]
 static long[] gang;
 static long fre;

    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
        long temp2[]=ilong();
        long n=temp2[0];
        long m=temp2[1];
         gang=new long[(int)n+1];
         long temp1[]=ilong();
         for(int i=1;i<=n;i++){
            gang[i]=temp1[i-1];
         }
         fre=find_fre();
        // System.out.println(fre);
        for (int i=0;i<=n ;i++ ) {
           graph[i]=new ArrayList<Long>();
        }
        for (int i=1;i<n ;i++ ) {
            long temp[]=ilong(); 
            long u=temp[0],v=temp[1];
            graph[(int)u].add(v);
             graph[(int)v].add(u);
        }
        
        for(int i=0;i<m ;i++ ) {
            long temp[]=ilong(); 
            long u=temp[0],v=temp[1];
            if(bfs(u,v,n)){
              if(fre==0)
              System.out.println("D "+u);
              else
                System.out.println("D "+fre);
            }
            else
              System.out.println("S");
          
        }


 
    }
  
    catch(Exception e){
        e.printStackTrace();}
    
  }
  long find_fre(){
    //long[] list = {1, 2, 3, 1, 1, 1, 1, 5, 6, 1569, 1, 2, 3, 2, 1569, 3};
    Map<Long,Long> map = new HashMap<Long,Long>();
    for (Long nextLong :gang) {
        Long count = map.get(nextLong);
        if (count == null) {
            count = 1L;
        } else {
            count = count + 1;
        }
        map.put(nextLong, count);
    }

    Long mostRepeatedNumber = null;
    Long mostRepeatedCount = null;
    Set<Long>keys = map.keySet();
    for (Long key : keys) {
        Long count = map.get(key);
        if (mostRepeatedNumber == null) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        } else if (count > mostRepeatedCount) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        } else if (count == mostRepeatedCount && key < mostRepeatedNumber) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        }
    }

    return mostRepeatedNumber;
        
  }
  boolean bfs(long start,long end,long n){
       boolean visited[]=new boolean[(int)n+1];
       long path[]=new long[(int)n+1];
       Arrays.fill(path,0);
       Queue<Long> st=new LinkedList<>();
       st.add(start);
        while(!st.isEmpty()){
            long u=st.poll();   
            for(int i=0;i<graph[(int)u].size();i++){
              Long pq=(Long)graph[(int)u].get(i);
              long v=(long)pq;
              if(!visited[(int)v]){
                visited[(int)u]=true;
                 st.add(v);
                  path[(int)v]=u;
              }
        }
        
        
  }
  
  long gang_member=0;
  long node=1;
  if(fre==0)
    gang_member=1;
  else if(gang[(int)end]==fre)
    gang_member=1;
  while(end!=start){
    if(path[(int)end]==0)
    {
      break;
    }
    else{
      end=path[(int)end];
      node++;
      if(fre==0)
        gang_member=1;
      else if(fre==gang[(int)end]){
          gang_member++;
        } 
          //System.out.println(end);
    }
  }
  //System.out.println(gang_member+" "+node);
        if(2*gang_member>=node)
          return true;
        else
          return false;
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