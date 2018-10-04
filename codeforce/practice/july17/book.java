import java.io.*;
import java.util.*;
import java.math.*;
//public 
class book{
    
    
    BufferedReader br;
    static int max=52;
    static long posvalue[]=new long[max];
    public static void main(String[] args) {
    new book().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     String line=si();
     String sep[]=line.split(",");

     long n=Long.parseLong(sep[0]),k=Long.parseLong(sep[1]);
     //posvalue=new long[n+1];
     for(int i=1;i<=n;i++){
      posvalue[i]=li();
     }
     long pos=1L;
     System.out.println(findsum(pos,k,n));

     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  long findsum(long pos,long k,long n){
    //System.out.println(pos);
    if(pos>n)
      return 0;
    long max1=posvalue[(int)pos]+findsum(pos+k+1,k,n);
    
     long max2=findsum(pos+1,k,n);
     //System.out.println(Math.max(max1,max2));
     return Math.max(max1,max2);
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


    