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
     String s=si();
     int k=ii();
     int[] hash=new int[27];
     Arrays.fill(hash,0);
     for(int i=0;i<s.length();i++){
       char c=s.charAt(i);
        hash[c-97]++;
     }
     int[] tt=new int[27];
     Arrays.fill(tt,0);
     for(int i=0;i<s.length();i++){
      char c=s.charAt(i);
      if(hash[c-97]>=k)
             tt[c-97]=1;
     }
     StringBuffer ans=new StringBuffer("");
     for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
      if(tt[c-97]==1)
        ans.append(c);
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