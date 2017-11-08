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
      int k=ii();
      String str=si();
      int sum_d=0;
      int ans=0;
      int[] arr=new int[str.length()];
      for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
         String digits=String.valueOf(ch);
         int temp=Integer.parseInt(digits);
         arr[i]=temp;
          sum_d+=temp;
         
      }
      if(k<=sum_d)
        System.out.println("0");
      else{
          Arrays.sort(arr);
          int count=0;
          sum_d=k-sum_d;
          for(int i=0;i<str.length();i++)
          {
              
              sum_d=sum_d-(9-arr[i]);
              if(sum_d<=0)
              {
                count++;
                break;
              }
              count++;
              
          }
          System.out.println(count);
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