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
     

      static int[] tree=null; 
    
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      int t=1;
      //t=ii();
      while(t-->0){
        
         //..........while loop start.
        int n=ii();
        int a[]=iint();
        construct(n,a);
        for(int i=0;i<5;i++){
          int aa[]=iint();
          if(aa[0]==1){
            System.out.println(getSum(aa[2])-getSum(aa[1]-1));
          }
          else{
            update(aa[1],aa[2],n);
            for (int k=0;k<=n ;k++ ) {
              System.out.print(tree[k]+" ");
            }
            System.out.println();
          }
        }

                














        // while loop end

      }
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  

  int getSum(int index){
    int sum=0;
    while(index>0){
      sum+=tree[index];
     index -= (index & (-index));
    }
    return sum;
  }
  void update(int index,int value,int n){
      while(index<=n){
        tree[index]+=value;
        index += (index & (-index));
      }
  }
  void construct(int n,int[] arr){
    tree=new int[n+1];
    Arrays.fill(tree,0);
    for(int i=1;i<=n;i++)
      update(i,arr[i-1],n);
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
    
} 