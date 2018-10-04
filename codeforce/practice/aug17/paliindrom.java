import java.io.*;
import java.util.*;
import java.math.*;

 //public 
 class Main{
  BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
  }
  void main1() 
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     int t=ii();
     while(t-->0){
       String a=si();
       String b=si();
       int[] aa=new int[27];
       int[] bb=new int[27];
       Arrays.fill(aa,0);
       Arrays.fill(bb,0);
       for (int i=0;i<a.length() ;i++ ) {
            aa[a.charAt(i)-97]++;

       }
       for (int i=0;i<b.length() ;i++ ) {
            bb[b.charAt(i)-97]++;
       }
       char ans='B';
       for (int i=0;i<27 ;i++ ) {
          if(aa[i]>=2 && bb[i]==0)
            {ans='A';break;}
          }
          System.out.println(ans);
    
    
     }
      
   }
   catch(Exception e){
        e.printStackTrace();}



}

   
   //input method
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
  
} 