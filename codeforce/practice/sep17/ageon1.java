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
     int n=ii();
     int[] arr=iint();
     Set<Integer> set=new HashSet<>();
     boolean ans=false;
     set.add(arr[0]);
     for(int i=1;i<n;i++)
      {
            if(arr[i]<arr[i-1] && arr[i]>=1 && arr[i]<=n){
              ans=true;
            }
            if(!set.contains(arr[i]) && arr[i]>=1 && arr[i]<=n){
              set.add(arr[i]);
            }
            else{
              ans=false;
              break;
            }
      }
      if(ans)
      System.out.println("Beautiful");
    else
      System.out.println("Ugly");
 
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