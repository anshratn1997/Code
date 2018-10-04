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
      int tt[]=iint();
      int n=tt[0],e=tt[1];
       HashSet<Integer> set=new HashSet<>();
       ArrayList<Integer> al=new ArrayList<>();
       int[] dic=new int[1000001];
      
       int[] a=iint();
       for (int i=0;i<n ;i++ ) {
          if(set.size()==0){
            set.add(a[i]);;
            al.add(a[i]);
            dic[a[i]]++;
            continue;
          }
          if(!set.contains(a[i])){
            set.add(a[i]);
            al.add(a[i]);

          }
          dic[a[i]]++;

       }
    Collections.sort(al);

     long[] cumm=new long[al.size()];
     long[] freq=new long[al.size()];
     cumm[0]=al.get(0)*1L*dic[al.get(0)];
     freq[0]=dic[al.get(0)];
     for (int i=1;i<al.size() ;i++ ) {
        cumm[i]=al.get(i)*1L*dic[al.get(i)]+cumm[i-1];
        freq[i]=dic[al.get(i)]+freq[i-1];
        // System.out.println(al.get(i)+" ");
     }
     // System.out.println();
     long max=dic[al.get(0)];
     for (int i=1;i<al.size() ;i++ ) {
         int j=0;
         while(j<i){
             long req=0;
             long mul=0;
            if(j==0){
              req=al.get(i)*1L*freq[i-1];
              req=req-cumm[i-1];
              mul=freq[i-1];
            
            }
            else{
              req=al.get(i)*1L*(freq[i-1]-freq[j-1]);
              req=req-(cumm[i-1]-cumm[j-1]);
              mul=freq[i-1]-freq[j-1];

            }
              if(req<=e){
                 max=Math.max(max,dic[al.get(i)]+mul);
                 break;
              }

              j++;

         }
         max=Math.max(max,dic[al.get(i)]);

     }
     System.out.println(max);
  
        









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