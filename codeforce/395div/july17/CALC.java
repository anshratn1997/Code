
import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;

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
      long t=li();
      while(t-->0){
        long temp[]=ilong();
        long n=temp[0],b=temp[1];
        long tt=n;
        long ans=0L;
         //System.out.println(tt);
        if(n%b!=0)
        {
           tt=tt-tt%b;
        }
       // System.out.println(tt);
        tt=(tt/b+1)/2;
        
        ans=n-b*tt;
        ans=ans*tt;
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