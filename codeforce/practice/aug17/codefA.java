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
           String str=si();
           int k=ii();
           int[] arr=new int[27];
           int count=0;
           
           if(str.length()<k)
            System.out.println("impossible");
          else{
           for (int i=0;i<str.length() ;i++ ) {
               if(arr[str.charAt(i)-97]==0){
                count++;
              arr[str.charAt(i)-97]=1;}
           }
           if(count>=k)
            {System.out.println("0");}
            else{
               System.out.println(k-count);
            }
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


    