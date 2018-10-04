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
     // t=ii();
      while(t-->0){

        //........solution start
        int n=ii();
        String card=si();
        String fuck[]=card.split(" ");
        ArrayList<Integer> h=new ArrayList<>();
        ArrayList<Integer> s=new ArrayList<>();
        ArrayList<Integer> d=new ArrayList<>();
        ArrayList<Integer> c=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          if(fuck[i].cahrAt(1)=='h'){
            Character ch=fuck[i].charAt(0);
            if(ch=='A')
              h.add(14);
            else if(ch=='K')
              h.add(13);
            else if(ch=='Q')
              h.add(12);
            else if(ch=='J')
              h.add(11);
            else if(ch=='T')
              h.add(10);
            else
            h.add(Integer.parseInt(ch.toString()));

          }
          if(fuck[i].cahrAt(1)=='s'){
            Character ch=fuck[i].charAt(0);
            if(ch=='A')
              s.add(14);
            else if(ch=='K')
              s.add(13);
            else if(ch=='Q')
              s.add(12);
            else if(ch=='J')
              s.add(11);
            else if(ch=='T')
              s.add(10);
            else
            s.add(Integer.parseInt(ch.toString()));
            
          }
          if(fuck[i].cahrAt(1)=='d'){
            Character ch=fuck[i].charAt(0);
            if(ch=='A')
              d.add(14);
            else if(ch=='K')
              d.add(13);
            else if(ch=='Q')
              d.add(12);
            else if(ch=='J')
              d.add(11);
            else if(ch=='T')
              d.add(10);
            else
            d.add(Integer.parseInt(ch.toString()));
            
          }
          if(fuck[i].cahrAt(1)=='c'){
            Character ch=fuck[i].charAt(0);
            if(ch=='A')
              c.add(14);
            else if(ch=='K')
              c.add(13);
            else if(ch=='Q')
              c.add(12);
            else if(ch=='J')
              c.add(11);
            else if(ch=='T')
              c.add(10);
            else
            c.add(Integer.parseInt(ch.toString()));
            
          }

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
int insertionSort(ArrayList<Integer> a, int n)
{
    int count=0;   
   return count;
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