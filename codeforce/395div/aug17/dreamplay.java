import java.io.*;
import java.util.*;
import java.math.*;

 public class dreamplay{
  BufferedReader br;
    public static void main(String[] args) {
    new dreamplay().main1();
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     String str=si();
     int l=str.length();
     int m1=pallindrom_match(str);
     int m2=Integer.MAX_VALUE;
     int index=-1;
     for (int i=0;i<l/2;i++){
            int temp=pallindrom_match(str.substring(i+1,l));
            if(temp<m2){
              index=i;
              m2=temp;
              //System.out.println(m2);
            }
        
            
     }
    System.out.println(Math.min(m1,m2+index+1));

      
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
   int pallindrom_match(String sub){
     int l=sub.length(),count=0;
      for (int i=0;i<l/2 ;i++ ) {
         if(sub.charAt(i)!=sub.charAt(l-i-1))
          count++;
      }
      return count;
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