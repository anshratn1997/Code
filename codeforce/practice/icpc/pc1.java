import java.io.*;
import java.util.*;
import java.math.*;
//public 
class pc1{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    ArrayList<Pair> al=null;

    // .......static class
  static class Pair{
      int key,value,wait;
      Pair(int key,int value,int wait){
        this.key=key;
        this.value=value;
        this.wait=wait;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
      }
      int Wait(){
        return wait;
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
    new pc1().main1();
 
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
     // t=ii();
      while(t-->0){

        //........solution start

        int n=ii();
        al=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          int[] tt=iint();
          al.add(new Pair(tt[0],tt[1],tt[2])); 
        }
        Collections.sort(al,new mycomparator());
        long ans[]=new long[1000001];
       
        int loc=n-1;
        Pair p1=al.get(n-1);
         long max=p1.Value();
        ans[p1.Key()]=p1.Value();
        for (int i=n-2;i>=0 ;i-- ) {
           Pair p=al.get(i);
           ans[p.Key()]=p.Value();
           int key=p.Key()+p.Wait()-1;
           int ind=upperBound(n,key);
           if(ind==n){
             if(max<p.Value()){
              max=p.Value();
             }
             ans[p.Key()]=max;
             continue;
           }
          // out.println("ind "+ind+" "+max);
           Pair pf=al.get(ind) ;
           if(ans[pf.Key()]+p.Value()>max){
            max=ans[pf.Key()]+p.Value();
            ans[p.Key()]=max;
           }
           else
            ans[p.Key()]=max;
          //out.println(ans[p.Key()]+" "+p.Key());
           
        }

        out.println(max);



  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.

 int upperBound(int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            Pair p=al.get(mid);

            if (value >=p.Key()) {
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