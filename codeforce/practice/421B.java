import java.io.*;
import java.util.*;
import java.math.*;
public class Main{
  
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     String line[]=br.readLine().split(" ");
       double n=Double.parseDouble(line[0]);
       double a=Double.parseDouble(line[1]);
       double angle=((n-2)*180.0)/n;
       // System.out.println(angle);
       angle=(180-angle)/2;

       //System.out.println(angle);
       int location=3;
      double ans=Math.abs(angle-a);
        for (int i=3;i<=n ;i++ ) {
            if(Math.abs(angle+angle*(i-3)-a)<ans)
               {
                location=i;
                ans=Math.abs(angle+angle*(i-3)-a);
               }
               
        }

       System.out.println("2 1 "+location);
       

     }
    catch(Exception e){
        e.printStackTrace();}

  }
  
  
}