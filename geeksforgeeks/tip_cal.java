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
      
         int[] tt=iint();
         int n=tt[0],na=tt[1],nb=tt[2];
         int[] a=iint();

         int []b=iint();
         ArrayList<Pair> al1=new ArrayList<>();
         ArrayList<Pair> al2=new ArrayList<>();

         for (int i=0;i<n;i++ ) {
            al1.add(new  Pair(a[i],i));
            al2.add(new  Pair(b[i],i));

          } 
          int aa=na-1;
          int bb=nb-1;
          Collections.sort(al1,new mycomparator());
          Collections.sort(al2,new mycomparator());
          int sum=0;
          int temp=n-1;
          int i=n-1,j=n-1;
          while(aa>=0 && bb>=0 && temp>=0)
          {
              Pair p1=al1.get(i);
              Pair p2=al2.get(j);
              if(p1.Key()==p2.Key())
                 {aa--;if(p1.Value()==p1.Value()){i--;j--;}else i--;}
              else if(p1.Key()>p2.Key())
                {aa--;if(p1.Value()==p2.Value()){i--;j--;}else i--;
                }
              else
                {bb--;if(p1.Value()==p2.Value()){i--;j--;}else j--;}
              sum+=Math.max(p1.Key(),p2.Key());
             temp--;
                   System.out.println(sum+" "+aa+" "+bb+" "+temp);
          }
          System.out.println("hejk");
          while(aa>=0 && temp>=0)
            {
              Pair p1=al1.get(i);
              sum+=p1.Key();aa--;temp--;i--;
              System.out.println(sum+" "+aa+" "+bb+" "+temp);
            }
            System.out.println("dfjkj");
            while(bb>=0 && temp>=0)
            {
              Pair p2=al1.get(j);
              sum+=p2.Key();
              bb--;temp--;j--;
              System.out.println(sum+" "+aa+" "+bb+" "+temp);
            }

          System.out.println(sum);


  
        









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