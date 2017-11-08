import java.io.*;
import java.util.*;
import java.math.*;
public class  hacker4{
    static long mod=0L;
    
    public static void main(String[] args) {
    new hacker4().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     String line[]=br.readLine().split(" ");
     int a[]=new int[n];
     for (int i=0;i<n ;i++ ) {
       a[i]=Integer.parseInt(line[i]);
     }
     int max=-1;
     int location=-1;
     for (int i=0;i<n ;i++ ) {
         if(a[i]>=n-i)
         {
          location=i;
          break;
         }
     }
     System.out.println(location+1);
     
   }
    catch(Exception e){
        e.printStackTrace();

    }

  }
  

}