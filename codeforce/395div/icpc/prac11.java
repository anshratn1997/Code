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
      int index;
      Pair(int key,int value,int index){
        this.key=key;
        this.value=value;
        this.index=index;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
      }
      int ind(){
        return index;
      }
  }
  static class Pair1{
      int key,value;
      Pair1(int key,int value){
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
  static class mycomparator1 implements Comparator<Pair1>{
     @Override
     public int compare(Pair1 o1,Pair1 o2){
      Integer key1=o1.Key(),key2=o2.Key();
          return key2.compareTo(key1);
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

      

        
        int tt[]=iint();
        int n=tt[0],bu=tt[1];
        int si[]=iint();
        int bc[]=iint();
        int br[]=iint();
        ArrayList<Pair> al=new ArrayList<>();
        ArrayList<Pair1> al1=new ArrayList<>();
        for (int i=0;i<bu ;i++ ) {
            al.add(new Pair(br[i],bc[i],i));
            

        }
        for (int i=0;i<n ;i++ ) {
          al1.add(new Pair1(si[i],i));
        }
        Collections.sort(al,new mycomparator());
        Collections.sort(al1,new mycomparator1());
        int[] ans=new int[n];
        boolean visit[]=new boolean[bu];
        Arrays.fill(visit,false);
        boolean find=false;
        for (int i=0;i<n ;i++ ) {
                Pair1 p1=al1.get(i);
                int size=p1.Key();
                find=false;
               for (int l=0;l<bu ;l++ ) {
                Pair p2=al.get(l);
                int sizel=p2.Value();
                  if(size<=sizel && !visit[l])
                  {
                    //System.out.println("heg "+l+" "+sizel);
                    ans[p1.Value()]=p2.ind()+1;
                    visit[l]=true;
                    
                    find=true;
                    break;

                  }
               }
               if(!find){
                //System.out.println(" find "+i);
                break;}

        }
        if(!find)
          System.out.println("impossible");
        else
        {
          for (int i=0;i<n ;i++ ) {
            System.out.print(ans[i]+" ");
          }
          System.out.println();
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