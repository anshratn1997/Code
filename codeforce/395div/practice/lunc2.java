import java.io.*;
import java.util.*;
import java.math.*;
//public 
class lunc2{
  
    public static void main(String[] args) {
    new lunc2().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int t=Integer.parseInt(br.readLine());
     while(t-->0){
     
     int n=Integer.parseInt(br.readLine());
     //System.out.println(n);
     int[] c=new int[n];
     int[] w=new int[n];
     String line1[]=br.readLine().split(" ");
     String line2[]=br.readLine().split(" ");
     //long comm[]=new long[n];
     
     long sum=0;
     for (int i=0;i<n ;i++ ) {
       c[i]=Integer.parseInt(line1[i]);
       w[i]=Integer.parseInt(line2[i]);
       sum+=w[i];
       //comm[i]=sum;
     }
     long mx=Long.MIN_VALUE;
     sum=0;
     int l=0,r=0;
     boolean[] visit=new boolean[n+1];
     Arrays.fill(visit,false);
     for (int i=0;i<n;) {
       if(!visit[c[i]])
       {
         sum+=w[i];
         visit[c[i]]=true;
         r=i;
         i++;
       }
       else{
          mx=Math.max(mx,sum);
        while(visit[c[i]])
         {
              sum-=w[l];
              visit[c[l]]=false;
              l+=1;
          
           }
        }
     }
     mx=Math.max(mx,sum);
     System.out.println(mx);
   }
 }
    catch(Exception e){
        e.printStackTrace();

    }

  }
  
  
}