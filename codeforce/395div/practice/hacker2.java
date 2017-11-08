import java.io.*;
import java.util.*;
import java.math.*;
public class  hacker2{
    public static void main(String[] args) {
    new hacker2().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     int a[][]=new int[n][n];
     for (int i=0;i<n;i++){
         
         String line[]=br.readLine().split(" ");
        
         for (int j=0;j<n ;j++ ) {
             a[i][j]=Integer.parseInt(line[0]);
         }
         
         
         }
         System.out.println("0");
     }
    catch(Exception e){
        e.printStackTrace();

    }

  }

}