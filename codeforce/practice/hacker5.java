import java.io.*;
import java.util.*;
import java.math.*;
public class  hacker5{
    static long mod=0L;
    
    public static void main(String[] args) {
    new hacker5().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int t=Integer.parseInt(br.readLine());
     while(t-->0){
      String line[]=br.readLine().split(" ");
      int n=Integer.parseInt(line[0]);
      int m=Integer.parseInt(line[1]);
      int temp=(n*(n-1))/2;
      if(m>=temp)
        System.out.println("-1");
      
     }
     
     
  }
    catch(Exception e){
        e.printStackTrace();

    }

  }
  
}