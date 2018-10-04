import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    
     static List graph[]=null;
     static int path[]=null;
     int[] arr=null;
    BufferedReader br;
    
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
       int n=ii();
       arr=iint();
       path=new int[n+1];
       graph =new ArrayList[n+1];
       for (int i=0;i<=n ;i++ ) {
           graph[i]=new ArrayList<Integer>();
        }
       for (int i=0;i<n-1 ;i++ ) {
           int temp[]=iint();
           graph[temp[0]].add(temp[1]);
           graph[temp[1]].add(temp[0]);           
       }
       System.out.print(arr[0]+" ");
       for (int i=2;i<=n ;i++ ) {
          System.out.print(findmax(1,i,n)+" ");
        } 
     }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  void bfs(int start,int end,int n){
       boolean visited[]=new boolean[n+1];  
       Arrays.fill(path,0);
       Queue<Integer> st=new LinkedList<>();
       st.add(start);
        while(!st.isEmpty()){
            int u=st.poll();   
            for(int i=0;i<graph[u].size();i++){
              int pq=(int)graph[u].get(i);
              int v=pq;
              if(!visited[v]){
                visited[u]=true;
                 st.add(v);
                  path[v]=u;
              }
         }
        
        
  }
}
   int findmax(int start,int end,int n){
    bfs(start,end,n);
   TreeSet<Integer> tr=new TreeSet<>();
   
    while(end!=start){
      tr.add(end);
    if(path[end]==0)
    {
      break;
    }
    else{
      end=path[end];
    }
  }

 return findGCD(tr);
}
int gcd(int a, int b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
}
 
int findGCD(TreeSet<Integer> tr)
{
    int result =1;
    int mx=-99;
   for(Integer i:tr){
        result=1;
       for(Integer j:tr) {
            if(i!=j){
            result = gcd(i, result);
            if(mx<result)
              mx=result;
              }
        } 
        
      }
    return result;
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


    