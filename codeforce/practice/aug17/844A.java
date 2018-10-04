import java.io.*;
import java.util.*;
import java.math.*;
public class Main{
    
    
    BufferedReader br;
    
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
          String st=si();
             String str[]=st.split(" ");
         int l,r,x,y;
         double k;
         l=Integer.parseInt(str[0]);
         r=Integer.parseInt(str[1]);
         x=Integer.parseInt(str[2]);
         y=Integer.parseInt(str[3]);
        k=Double.parseDouble(str[4]);
        boolean ans=false;
        for (int i=x;i<=y ;i++ ) {
            double temp=k*i;
            if((int)temp>=l && (int)temp<=r){
              ans=true;break;
            }
        }
        if(ans)
          System.out.println("YES");
        else
          System.out.println("NO");
         
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


    