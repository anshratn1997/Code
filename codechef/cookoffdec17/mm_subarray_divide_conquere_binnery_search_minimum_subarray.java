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
    static int[] a=null;
    static  int ans=100001;
    static int[] prefix=null;
    static int d=0;

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
    new Main().main1();
 
  }
  void main1()
  {
    try{
       
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
      int t=1;
      t=ii();
      while(t-->0){

        //........solution start
        int nd[]=iint();
        int n=nd[0];
        d=nd[1];
        a=iint();
        prefix=new int[n];
        divide(0,a.length-1);

        if(ans==100001)
          out.println("-1");
        else
        out.println(ans);
      ans=100001;


      

  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  void divide(int l,int r){
    if(l<r){
        int mid=(l+r)/2;
        divide(l,mid);
        divide(mid+1,r);
        merge(l,mid,r);
     }
  }
  void merge(int l,int mid,int r){
    ArrayList<Pair> right=new ArrayList<>();
    int sum=a[l];
    int el=1;
    prefix[l]=sum;
    if(prefix[l]>=d)
          ans=Math.min(ans,el);
     for (int i=l+1;i<=mid ;i++ ) {
       sum+=a[i];
       el++;
       prefix[i]=sum;
       if(prefix[i]>=d)
          ans=Math.min(ans,el);
     }
    sum=a[mid+1];
    prefix[mid+1]=sum;
    el=1;
    if(prefix[mid+1]>=d)
          ans=Math.min(ans,el);
    right.add(new Pair(sum,1));
     for (int i=mid+2;i<=r ;i++ ) {
        sum+=a[i];
        el++;
        prefix[i]=sum;
        if(prefix[i]>=d)
          ans=Math.min(ans,el);
        right.add(new Pair(sum,el));
     }
     Collections.sort(right,new mycomparator());
     int[] mine=new int[right.size()];
     mine[right.size()-1]=right.get(right.size()-1).Value();
     for (int i=right.size()-2;i>=0 ;i-- ) {
        mine[i]=Math.min(mine[i+1],right.get(i).Value());
     }
    int ind=0;
    ind=upperBound(right,right.size(),d-prefix[mid]-1);
    if(ind!=right.size())
      ans=Math.min(ans,mine[ind]+mid-l+1);
     for (int i=l;i<mid ;i++ ) {
       ind=0;
       ind=upperBound(right,right.size(),d-prefix[mid]+prefix[i]-1);
       if(ind!=right.size()){
       ans=Math.min(ans,mine[ind]+mid-i);
       
     }
       
  }


     // for (int i=mid+1;i<=r ;i++ ) {
     //   prefix[i]=prefix[i]+prefix[mid];
     // }
  }
   public  int upperBound(ArrayList<Pair> array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array.get(mid).Key()) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
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