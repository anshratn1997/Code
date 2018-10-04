import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
   static List graph[]=null;
      static int path[]=null;
      static boolean visited[]=null;
   // ArrayList<Integer> traverse=new ArrayList<>();
   static int spec=0;
 BufferedReader br;
 

    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      int n=ii();
       //arr=iint();
       path=new int[n+1];
       graph =new ArrayList[n+1];
       visited=new boolean[n+1];
       Arrays.fill(path,0);
       Arrays.fill(visited,false);
       
       for (int i=0;i<=n ;i++ ){graph[i]=new ArrayList<Integer>();}
       for (int i=0;i<n-1 ;i++ ) {
           int temp[]=iint();
           graph[temp[0]].add(temp[1]);
           graph[temp[0]].add(temp[2]);

           graph[temp[1]].add(temp[0]);
           graph[temp[1]].add(temp[2]);           
       }
      // for(int i=1;i<=n;i++)
        //  System.out.println(graph[i].get(0)+" "+graph[i].get(1));
       dfs(1);
        for(int i=1;i<=n;i++)
          System.out.print(path[i]+" ");
       Arrays.fill(visited,false);
       
       dfs1(1);
     //  System.out.println(spec);
        
       int mod=1000000007;
       int edge=n-1-spec;
       long ans=power(2,edge,mod);
       //System.out.println(ans);
     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  void dfs(int u){
   // traverse.add(u);
    visited[u]=true;
    for(int i=0;i<graph[u].size();i+=2)
     {
         int v=(int)graph[u].get(i);
         
         if(!visited[v]){
          dfs(v);
         }
         if((int)(graph[u].get(i+1))==1){
            path[u]=path[u]+1;
            if(path[v]>path[u])
           path[u]=path[u]+path[v]-1;
         }
         else
         if(path[v]>path[u])
           path[u]=path[u]+path[v];
         
     }
}
void dfs1(int u){
  visited[u]=true;
     if(path[u]>0){
           spec++;
           //System.out.println("heloo "+u);
              for(int i=0;i<graph[u].size();i+=2)
              {     int v=(int)graph[u].get(i);
                   if(!visited[v])
                     dfs1(v);
              }
     }

}
int power(int x,int y, int p)
{
    int res = 1;      // Initialize result
    if(y==0)
      return 1;
    x = x % p;  // Update x if it is more than or 
                // equal to p
 
    while (y > 0)
    {
        // If y is odd, multiply x with result
        if (y%2==1)
            res = (res*x) % p;
 
        // y must be even now
        y = y>>1; // y = y/2
        x = (x*x) % p;  
    }
    return res;
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