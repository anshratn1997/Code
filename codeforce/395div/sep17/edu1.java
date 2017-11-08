import java.io.*;
import java.util.*;
import java.math.*;
public class edu1{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    static ArrayList<Pair> build=null;
    static Long tree[]=null;
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
    new edu1().main1();
 
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
        int tt[]=iint();
        int n=tt[0],q=tt[1];
        build=new ArrayList<>();
        tree=new Long[n*5];

        for (int i=0;i<n ;i++ ) {   
          int temp[]=iint();
          build.add(new Pair(temp[0],temp[1]));
        }
        Collections.sort(build,new mycomparator());
     
        cnstr(1,0,n-1);
        for (int i=0;i<q ;i++ ) {
          int tt1[]=iint();
          long ans=1L*Math.abs(tt1[1]-tt1[3])+1L*Math.abs(tt1[0]-tt1[2]);
          int l=upperBound(build.size(),Math.min(tt1[0],tt1[2]));
          int r=upperBound(build.size(),Math.max(tt1[0],tt1[2]))-1;
          //System.out.println("l and r:"+l+" "+r);
          if(r>=l){
            long mx=getmax(1,0,n-1,l,r);
            if(mx>=Math.max(tt1[1],tt1[3])){
              ans=ans+2L*(1+mx-Math.max(tt1[1],tt1[3]));
            }
          }
          out.println(ans);
        }



        //..........solution end.
     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  void cnstr(int nd, int a, int b){
    if(a > b){
      tree[nd] = -1000000001*1L;
    }
    if(a == b) {
        Pair p=build.get(a);
        tree[nd] = (long)p.Value();       
        return;
    }
    cnstr(nd*2, a, (a+b)/2);
    cnstr(nd*2+1, 1+(a+b)/2, b);
    tree[nd] = Math.max(tree[nd*2],tree[nd*2+1]);

}
long getmax(int nd, int a, int b, int i, int j) {
 
   
   if(a > b || a > j || b < i) return -1000000001;
  
    if(a >= i && b <= j)
    {    
        return tree[nd];
    }
 
  long q1 = getmax(nd*2, a, (a+b)/2, i, j);
  long q2 = getmax(1+nd*2, 1+(a+b)/2, b, i, j);
 
  long res = Math.max(q1, q2);
  return res;
 
}

 public  int upperBound(int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            Pair p=build.get(mid);

            if (value >= p.Key()) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
  }


 
   


  //................end.
  
  
   //..............input method start. 
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