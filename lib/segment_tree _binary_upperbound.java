import java.io.*;
import java.util.*;
import java.math.*;
//public 
class edu11{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    int a[]=null;
    boolean visited[]=null;
    boolean visited1[]=null;
    int[] finish=null;
    int[] count=null;

    // .......static class
 
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new edu11().main1();
 
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
        int n=ii();
        a =iint();
        ArrayList<HashSet<Integer>> al=new ArrayList<>();
       
        visited=new boolean[n+1];
        visited1=new boolean[n+1];
        finish=new int[n+1];
        count=new int[n+1];
        Arrays.fill(visited,false);

         Arrays.fill(visited,false);
        for (int i=1;i<=n ;i++ ) {
            int temp=i;
            HashSet<Integer> set1=new HashSet<>();
            if(visited[i])
              continue;
            while(!visited[temp]){
                  visited[temp]=true;
                  set1.add(temp);
                  temp=a[temp-1];

                }
            if(al.size()<2){
                  al.add(set1);
                }
            else{
             
                  for (int l=0;l<2 ;l++ ) {
                    HashSet tt1=al.get(l);
                   
                    if(tt1.size()<set1.size())
                      {
                        al.set(l,set1);break;
                      } 

                  }
                  
           }
        }
        HashSet<Integer> set=new HashSet<>(al.get(0));

        if(al.size()==2)
        set.addAll(al.get(1));

      long ans=set.size()*set.size();
       System.out.println(ans);
       
       for (int i=1;i<=n ;i++ ) {
            if(set.contains(i)){
             visited1[i]=true;
            } 
       }
      for (int i=1;i<=n ;i++ ) {
         if(!set.contains(i)){
          //
          if(!visited1[i])
            dfs(i);
          System.out.println(i+" "+count[i]+" "+finish[i]);
          ans=ans+count[i]+1;
         }

      }
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
  void dfs(int u){
    visited1[u]=true;
    int temp=a[u-1];
    //System.out.println(" temp called "+temp);
    if(!visited1[temp])
      dfs(temp);
    if(finish[temp]!=0){
       finish[u]=finish[temp];
       if(u==finish[u])
        count[u]=count[temp];
       else
        count[u]=count[temp]+1;
     }
    else{
      finish[u]=temp;
       if(u==finish[u])
        count[u]=count[temp];
       else
        count[u]=count[temp]+1;
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