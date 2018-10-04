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
        int xn[]=iint();
        int x=xn[0],n=xn[1];
        int tt=n;
        long s1=0,s2=0;
        // s1=(n*(n+1))/2-x;
        // if(s1%2!=0){out.println("impossible");continue;}
        // s1=0;
        int[] a=new int[n+1];
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        Arrays.fill(a,-1);
        while(tt>0){
          if(tt==x){
            a[tt]=2;
            tt--;
            continue;
          }
          if(s1>s2){
             s2+=tt;a[tt]=1;al2.add(tt);}
          else{
            s1+=tt;a[tt]=0;al1.add(tt);
          }
          tt--;
        }
        if(al1.size()==0 || al2.size()==0)
          {out.println("impossible");continue;}
        if(s1==s2)
           printarr(a);
      else{
         if(s1>s2 && s1-s2==2){
          int i=0,j=0;
          boolean find=false;
            while(i<al1.size() && j<al2.size()){
              if(al1.get(i)>al2.get(j) && al1.get(i)-al2.get(j)==1)
              {
                a[al1.get(i)]=1;a[al2.get(j)]=0;
                 printarr(a);
                 find=true;
                break;
              }
              else{i++;j++;}
            }
            if(!find)
              out.println("impossible");


           
         }
         else if(s2>s1 && s2-s1==2){
          int i=0,j=0;
          boolean find=false;
            while(i<al1.size() && j<al2.size()){
              if(al1.get(i)<al2.get(j) && al2.get(j)-al1.get(i)==1)
              {
                a[al1.get(i)]=1;a[al2.get(j)]=0;
                find=true;
              printarr(a);

                break;
              }
              else{i++;j++;}
            }
            if(!find)
              out.println("impossible");
         }

         else
          out.println("impossible");

        
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
  void printarr(int[] a)
  {
    for (int i=1;i<a.length ;i++ ) {
      
    out.print(a[i]);
    }
    out.println();
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