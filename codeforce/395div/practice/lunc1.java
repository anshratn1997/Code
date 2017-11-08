import java.io.*;
import java.util.*;
import java.math.*;
//public 
class lunc1{
  
    public static void main(String[] args) {
    new lunc1().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int t=Integer.parseInt(br.readLine());
     while(t-->0){
     String line[]=br.readLine().split(" ");
     int a=Integer.parseInt(line[0]);
     int b=Integer.parseInt(line[1]);
     int n=Integer.parseInt(line[2]);
     if(n%2==0){
      System.out.println(Math.max(a,b)/Math.min(a,b));
     }
     else
     {
      System.out.println(Math.max(a*2,b)/Math.min(a*2,b));
     }
    
     
   }
 }
    catch(Exception e){
        e.printStackTrace();

    }

  }
  
  
}