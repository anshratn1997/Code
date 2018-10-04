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
      int key;
      char value;
      Pair(int key,char value){
        this.key=key;
        this.value=value;
      }
      int Nm(){
        return key;
      }
      char Ch(){
        return value;
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
         // int[] mn=iint();
       String s1=si();
       String s2=si();
        // int n=mn[0],m=mn[1];
       int n=s1.length(),m=s2.length();
       StringBuffer sb1=new StringBuffer("");
       StringBuffer sb2=new StringBuffer("");
       ArrayList<Integer> al1=new ArrayList<>();
       ArrayList<Integer> al2=new ArrayList<>();
       
       int tt=1;
       sb1.append(s1.charAt(n-1));
       for (int i=n-2;i>=0 ;i-- ) {
          if(s1.charAt(i)==s1.charAt(i+1))
            tt++;
          else
            {
              sb1.append(s1.charAt(i));
              al1.add(tt);
              tt=1;

            }

       }
       al1.add(tt);
       tt=1;
       sb2.append(s2.charAt(m-1));
       for (int i=m-2;i>=0 ;i-- ) {
          if(s2.charAt(i)==s2.charAt(i+1))
            tt++;
          else
            {
              sb2.append(s2.charAt(i));
              al2.add(tt);
              tt=1;

            }

       }
       al2.add(tt);
       sb1=sb1.reverse();
       sb2=sb2.reverse();
       n=sb1.length();m=sb2.length();
      Pair[][] mat=new Pair[n+1][m+1];
       mat[0][0]=new Pair(0,'0');
       for (int i=1;i<=n ;i++ ) {
         if(mat[i-1][0].Ch()!=sb1.charAt(i-1))
          mat[i][0]=new Pair(mat[i-1][0].Nm()+1,sb1.charAt(i-1));
        else
          mat[i][0]=new Pair(mat[i-1][0].Nm(),sb1.charAt(i-1));
 
       }
       for (int i=1;i<=m ;i++ ) {
        if(mat[0][i-1].Ch()!=sb2.charAt(i-1))
            mat[0][i]=new Pair(mat[0][i-1].Nm()+1,sb2.charAt(i-1));
        else
            mat[0][i]=new Pair(mat[0][i-1].Nm(),sb2.charAt(i-1));
       }
       for (int i=1;i<=n ; i++) {
          for (int j=1;j<=m ;j++ ) {
             int v2=mat[i-1][j].Nm(),v1=mat[i][j-1].Nm();
             char ch2=mat[i-1][j].Ch(),ch1=mat[i][j-1].Ch();
             if(sb2.charAt(j-1)!=ch1)
               v1++;
             if(sb1.charAt(i-1)!=ch2)
              v2++;
             if(v1>v2)
              mat[i][j]=new Pair(v2,sb1.charAt(i-1));
             else
              mat[i][j]=new Pair(v1,sb2.charAt(j-1));
 
          }
       }
       out.println(mat[n][m].Nm());
       

       
       

      

  
        









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