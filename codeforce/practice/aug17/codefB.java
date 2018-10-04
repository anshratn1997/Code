import java.io.*;
import java.util.*;
import java.math.*;
public class digits{
    
    
    BufferedReader br;
    
    public static void main(String[] args) {
    new digits().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     long temp[]=ilong();
      long n=temp[0],m=temp[1];
      int[][] arr=new int[(int)n][(int)m];
      for (int i=0;i<(int)n ;i++ ) {
         String line=si();
         String list[]=line.split(" ");
         for (int j=0;j<(int)m ;j++ ) {
            arr[i][j]=Integer.parseInt(list[j]);
         }
      }
      long ans=0L;
      for (int i=0;i<(int)n ;i++ ) {
          long count_0=0L;
          long count_1=0L;
         for (int j=0;j<(int)m;j++ ) {
             if(arr[i][j]==0)
              count_0++;
             if(arr[i][j]==1)
              count_1++;
         }
         ans=ans+(long)Math.pow(2,count_1)+(long)Math.pow(2,count_0);
      }
      for (int i=0;i<(int)m ;i++ ) {
          long count_0=0;
          long count_1=0;
         for (int j=0;j<(int)n ;j++ ) {
             if(arr[j][i]==0)
              count_0++;
             if(arr[j][i]==1)
              count_1++;
         }
         ans=ans+(long)Math.pow(2,count_1)+(long)Math.pow(2,count_0);
      }
      ans=ans-(2*n+2*m+m*n);
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


    