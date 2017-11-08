import java.io.*;
import java.util.*;
import java.math.*;

 //public 
 class owner{
  BufferedReader br;
  //static int[] enc=new int[10];
    public static void main(String[] args) {
    new owner().main1();
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     //System.out.println(calculate9("JAABHD"));
     int n=ii();
     String input=si();
     String reading[]=input.split(" ");
     int centre=ii();
     int sum=0;
     for (int i=0;i<n ;i++ ) {
        sum+=calculate9(reading[i]);
        //System.out.println(calculate9(reading[i]));
     }
     if(sum<centre)
     {
      System.out.println("INNOCENT");
      
     }
     else{
      System.out.println("GREEDY");
      System.out.println(sum-centre);
     }
      


     //System.out.println(calculate9(si()));

     

      
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  int calculate9(String bill)
  {
      StringBuffer sb=new StringBuffer("");
      for (int i=0;i<5;i++ ) {
          Integer temp=bill.charAt(i)-65;
          //System.out.println(temp);
          Integer temp1=bill.charAt(i+1)-65;
          //System.out.println(temp1);
          if(temp==5 && temp1==4)
              {
                //System.out.println("df");
              sb.append(temp1.toString());}
          else if(temp==6 && temp1==3)
             {sb.append(temp1.toString());}
          else if(temp==7 && temp1==2)
                {sb.append(temp1.toString());}
          else if(temp==8 && temp1==1)
                  {sb.append(temp1.toString());}
          else if(temp==9 && temp1==0)
                    {sb.append(temp1.toString());}
          else
          {  sb.append(temp.toString());
          }

      }
      Integer last=bill.charAt(5)-65;
      sb.append(last.toString());
      return Integer.parseInt(sb.toString());
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