import java.io.*;
import java.util.*;
import java.math.*;
public class Main{
    
    
    BufferedReader br;
    
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
       double temp[]=idouble();
       int n=ii();
       int ans=0;
       for (int i=0;i<n ;i++ ) {
          double tempq[]=idouble();
          double dist=Math.sqrt(Math.pow(tempq[0],2)+Math.pow(tempq[1],2));
          
          if(Math.abs(temp[0]-temp[1])<=(dist-tempq[2]) && temp[0]>=(dist+tempq[2])){
             ans+=1;
             //System.out.println(i);
           }

       }
       System.out.println(ans);
        
         
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


    