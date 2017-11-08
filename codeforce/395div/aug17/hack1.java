import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    
    
    BufferedReader br;
    static boolean ans=false;
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
       
       String str=si();
       int len=str.length();
    if(len==2 && str.charAt(0)==str.charAt(1))
      {ans=true;}
    else
       mergesort(str);
     if(ans)
       System.out.println("yes");
     else
      System.out.println("no");
   }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  void mergesort(String str){
    int len=str.length();
    if(len>2){
      int mid=len/2;
      mergesort(str.substring(0,mid+1));
      mergesort(str.substring(mid+1,len));
      //System.out.println(str);
     merge(str);
    }
    //return false;
  }
  void merge(String str){
    int len=str.length();

    if(!ans){
      int j=0,i=0;
    for(i=0,j=len-1;i<len/2 && j>len/2;i++){
      if(str.charAt(i)==str.charAt(j)){j--;}
      else j=len-1;
   }
   if(j==len/2 && i==len/2)
    ans=true;
    
}
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


    