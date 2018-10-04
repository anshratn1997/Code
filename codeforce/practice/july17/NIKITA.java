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
        String str=si();
        String[] arr=str.split(" ");
        String st=". ";
         if(arr.length==1)
         {
          char c=arr[0].charAt(0);
          int ch=(int)c;
          if((int)c>=97)
          ch=(int)c-32;
          System.out.print((char)ch);
          for (int i=1;i<arr[0].length() ;i++ ) {
            int chh=(int)arr[0].charAt(i);
               if(chh<97)
                 System.out.print((char)(chh+32));
               else 
                System.out.print((char)chh);
            
          }
         }
         else
         {
          for (int i=0;i<arr.length-1;i++ ) {
            char c=arr[i].charAt(0);
            int ch=(int)c;
            if((int)c>=97)
            ch=(int)c-32;
            System.out.print((char)ch+st);
          }

          char c=arr[arr.length-1].charAt(0);
           int ch=(int)c;
          if((int)c>=97)
           ch=ch-32;
          System.out.print((char)ch);
          int last=arr.length-1;
          for (int i=1;i<arr[last].length() ;i++ ) {
            int chh=(int)arr[last].charAt(i);
               if(chh<97)
                 System.out.print((char)(chh+32));
               else 
                System.out.print((char)chh);
            
          }

         }
         System.out.println();
        
      	
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