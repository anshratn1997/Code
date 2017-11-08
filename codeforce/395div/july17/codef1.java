import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
 public class Main{
	static long mod1=1000000007L;
	static long mod2=1000000009L;
 
 BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     int temp[]=iint();
     int s=temp[0];

      int v1=temp[1];
       int v2=temp[2];
       int t1=temp[3];
       int t2=temp[4];
       int ans1=s*v1+2*t1;
       int ans2=s*v2+2*t2;
       if(ans1==ans2)
        System.out.println("Friendship");
       else if(ans1<ans2){
        System.out.println("First");

       }
       else
        System.out.println("Second");
       

      
    
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