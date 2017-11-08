
import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
       int n=ii();
       int count=1;
       for(int i=1;i<=n;i++)
       {
       	   for(int j=n-i;j>0;j--){
       	     System.out.print(" ");
       	   }
       	   //System.out.println("ok;");
       	   for(int j=1;j<=i;j++){
               int temp=2*count*(4*count-1);
               int temp1=temp;
               int digit=0;
               while(temp1!=0){
               	 digit++;
               	 temp1=temp1/10;
               }
               for (int k=1;k<=5-digit ;k++ ) {
               	    System.out.print("0");
               }
               System.out.print(temp);
               count++;
               System.out.print(" ");
              // System.out.println("ok1");
       	   }
       	   System.out.println();
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