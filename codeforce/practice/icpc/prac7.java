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
    static final int MAX=100;
   static boolean prime[]=new boolean[101]; 
   static int pcount[]=new int[100001];

    // .......static class
  static class Pair{
      int key,value;
      Set<String> set;
      Pair(int key,int value,Set<String> set){
        this.key=key;
        this.value=value;
        this.set=set;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
      }
      Set send(){
        return set;
      }
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Integer key1=o1.Value(),key2=o2.Value();
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
        int n=ii();
        
        ArrayList<Pair> al=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          //System.out.println("dfd");
          String line=si();
          String[] ll=line.split(" ");
          int st=Integer.parseInt(ll[1]);
          int se=Integer.parseInt(ll[2]);
          int num=Integer.parseInt(ll[3]);
          Set<String> al1=new HashSet<String>();
          for (int l=0;l<num ;l++ ) {
             al1.add(ll[l+4]);
          }
          al.add(new Pair(st,se,al1));

        }
        Collections.sort(al,new mycomparator());
        TreeSet<String> ts=new TreeSet<>();
        for (int i=0;i<n ;i++ ) {

            Pair pi=al.get(i);
            for (int j=i+1;j<n ;j++ ) {
               Pair pj=al.get(j);
               if(pj.Key()<=pi.Value()){
                 //System.out.println("l and j "+i+" "+j);
                  
                  Set<String> sl=pi.send();
                  Set<String> sj=pj.send();
                 

                  for (String inp:sl) {
                    if(!ts.contains(inp) && sj.contains(inp))
                        ts.add(inp);
                      //System.out.print("hello "+j+" " +inp);
                  }
                  //System.out.println();
               }
               
            }
          
        }
        out.println(ts.size());
        for (String ans:ts ) {
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