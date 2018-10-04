import java.io.*;
import java.util.*;
import java.math.*;
//public 
class prac13{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;

    // .......static class
  static class Pair{
      double key,d;
      int value;
      Pair(double key,int value,double d){
        this.key=key;
        this.value=value;
        this.d=d;
      }
      double Key(){
        return key;
      }
      int Value(){
        return value;
      }
      double dis(){
        return d;
      }
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Double key1=o1.Key(),key2=o2.Key();
          return key1.compareTo(key2);
     }
  }
  
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new prac13().main1();
 
  }
  void main1()
  {
    try{
      if (System.getProperty("ONLINE_JUDGE") == null) {
        // Input is a file
        br=new BufferedReader(new FileReader(new File("in.txt")));
        out=new PrintWriter("out.txt");
       } else {
        // Input is System.in
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
      }
      
   
      int t=1;
      t=ii();
      while(t-->0){

        //........solution start

           int[] tt=iint();
           int n=tt[0],m=tt[1],k=tt[2];
           ArrayList<String> sl=new ArrayList<>();
           for (int i=0;i<n ;i++ ) {
             
               sl.add(si());
           }
           int ans[]=new int[n];

          Arrays.fill(ans,0);
           for (int i=0;i<n ;i++ ) {
             String temp=sl.get(i);
               for (int l=0;l<m ;l++ ) {
                  if(temp.charAt(l)=='*'){
                     ans[i]++;
                   }

               }
           }
        
           boolean visit[]=new boolean[n];
           Arrays.fill(visit,false);

         for (int i=0;i<n ;i++ ) {
            if(ans[i]>=m-ans[i])
              continue;
            int loc=i;
            int min=ans[i];
            for (int l=0;l<n ;l++ ) {
                if(min>ans[l])
                {
                  loc=l;
                  min=ans[l];
                }
            }
            ans[loc]=m-ans[loc];
            k--;
            if(k<=0)
              break;
         }
         
         if(k%2==0){
          int total=0;
          for (int i=0;i<n ;i++ ) {
            total+=ans[i];
          }
          out.println(total);
         }
         else{
          int loc=0;
          int min=ans[0];
              for (int i=0;i<n ;i++ ) {
                 if(min>ans[i]){
                  loc=i;
                  min=ans[i];
                 }
              }
            ans[loc]=m-ans[loc];
            int total=0;
            for (int i=0;i<n ;i++ ) {
              total+=ans[i];
            }
            out.println(total);
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
  void print1(int[] ans,int n){

         for (int i=0;i<n ;i++ ) {
          System.out.println(ans[i]+" ");
        }
        System.out.println();
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