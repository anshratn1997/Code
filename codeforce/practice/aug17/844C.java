import java.io.*;
import java.util.*;
import java.math.*;
public class Main{
    
      static List graph[]=null;
      static int path[]=null;
      static boolean visited[]=null;
      ArrayList<Integer> traverse=new ArrayList<>();
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
       visited=new boolean[n+1];
       Arrays.fill(path,0);
       Arrays.fill(visited,false);
       int[][] dp=new int[n+1][3];
       for (int i=0;i<=n ;i++ ) {
         Arrays.fill(dp[i],-1);
       }
       
       for (int i=0;i<=n ;i++ ){graph[i]=new ArrayList<Integer>();}
       for (int i=0;i<n-1 ;i++ ) {
           int temp[]=iint();
           graph[temp[0]].add(temp[1]);
           graph[temp[1]].add(temp[0]);           
       }
       
       dfs(1);
       dp[1][0]=arr[0];dp[1][1]=0;dp[1][2]=0;
      //  for (int i=0;i<traverse.size() ;i++ ) {
       // System.out.print(traverse.get(i)+" ");
       //}
       //System.out.println();
       for (int i=1;i<traverse.size() ;i++ ) {
           int child=traverse.get(i);
           int dad=path[child];
           int temp_1=gcd(dp[dad][0],arr[child-1]);
           //if(i==1)
           // System.out.println(temp_1);
           if(temp_1<dp[dad][0]){
            dp[child][0]=temp_1;dp[child][1]=dp[dad][0];
           }
           else
            dp[child][0]=dp[dad][0];

       if(dp[dad][1]!=-1)
         dp[child][2]=Math.max(gcd(dp[dad][1],arr[child-1]),gcd(dp[dad][2],arr[child-1]));
        else
           dp[child][2]=gcd(dp[dad][2],arr[child-1]);

           
       }
       for (int i=1;i<=n ;i++ ) {
        //System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);
       System.out.print(Math.max(dp[i][0],Math.max(dp[i][1],dp[i][2]))+" ");
       }
       
     }
    catch(Exception e){
        e.printStackTrace();}
  }
void dfs(int u){
    traverse.add(u);
    visited[u]=true;
    for(int i=0;i<graph[u].size();i++)
     {
          int v=(int)graph[u].get(i);
         if(!visited[v]){
          path[v]=u;
          dfs(v);
         }
     }
}
  
int gcd(int a, int b)
{
    if (a == 0)
        return b;
    if(b==0)
      return a;
    return gcd(b%a, a);
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


    