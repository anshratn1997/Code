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
    static ArrayList<Double> ans=new ArrayList<>();
    static double[] dd=null;
    static double[] aa=null;
    static Pair[] pp=null;


    // .......static class
  static class Pair{
      double key,value;
      Pair(double key, double value){
        this.key=key;
        this.value=value;
      }
      double Key(){
        return key;
      }
      double Value(){
        return value;
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
    new Main().main1();
 
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
       dd=idouble();
       aa=idouble();
      pp=new Pair[n];
      for (int i=0;i<n ;i++ ) {
         pp[i]=new Pair(dd[i],aa[i]);
      }
      Arrays.sort(pp,new mycomparator());
       for (int pos=0;pos<n-1 ;pos++ ) {
          search_pos(pos,n,pp[pos].Key(),pp[pos+1].Key());
       }
       System.out.println(ans.size());
       // Collections.sort(ans)
       for(Double i:ans)
        System.out.print(i+" ");


  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.

 void search_pos(int pos,int n,double lo ,double hi){
    int itr=0;
    while(lo<=hi){
      if(itr>70)
        break;
      double mid=(lo+hi)/2;
      int calc=cal_sum(pos,n,mid);
      if(calc==0){
        ans.add(mid);
        break;
      }
      else if(calc==-1)
        lo=mid;
      else
        hi=mid;
      itr++;
    }
 }
 int cal_sum(int pos,int n,double mid){
  double suml=0.0;
  double sumr=0.0;
  for(int i=0;i<=pos;i++)
    suml+=pp[i].Value()/Math.log(2+mid-pp[i].Key());
  for(int i=pos+1;i<n;i++)
    sumr+=pp[i].Value()/Math.log(2+pp[i].Key()-mid);
  if(Math.abs(sumr-suml)<=eps)
    return 0;
  else if(suml>sumr)
    return -1;
  else return 1;

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
        a[i]=Double.parseDouble(line[i]);
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