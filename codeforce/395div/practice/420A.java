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
     int n=Integer.parseInt(br.readLine());
      int[][] a=new int[n][n];
      for (int i=0;i<n ; i++) {
        String line[]=br.readLine().split(" ");
        for (int j=0;j<n ;j++ ) {
            a[i][j]=Integer.parseInt(line[j]);
        }
      }
      boolean flag=false;
      boolean ans=true;
     for (int i=0;i<n ; i++) {
        for (int j=0;j<n ;j++ ) {
          flag=false;
           if(a[i][j]!=1){
            int sum=0;
            for (int k=0;k<n;k++ ) {
                if(k!=i){
                  sum+=a[k][j];
                for (int l=0;l<n ;l++ ) {
                   if(l!=j){
                     sum+=a[i][l];
                     if(sum==a[i][j]){ flag=true;  break;
                     }
                     sum-=a[i][l];
                   }

                }
                sum=0;
                if(flag==true)
                  break;
              }
            }
            if(flag==false){ans=false;
              break;}
                
           }
        }
        if(ans==false)break;
      }
      if(ans==false)
        System.out.println("No");
      else
        System.out.println("Yes");
     }
    catch(Exception e){
        e.printStackTrace();}

  }
  
}