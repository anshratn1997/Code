
import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
  
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     String line[]=br.readLine().split(" ");
       long c=Long.parseLong(line[0]);
       long v0=Long.parseLong(line[1]);
       long v1=Long.parseLong(line[2]);
       long a=Long.parseLong(line[3]);
       long l=Long.parseLong(line[4]);
       long current=v0;
       long i=1;
       long ans=0;
       long v=v0;
       if(v0>=c)
        System.out.println("1");
       long sum=0;
       while(true)
       {
         if(ans!=0)
         {
          if(sum<=l){
            c+=sum;
            sum=0;
          }
          else{
            c+=1;
            sum-=1;
          }
         }
         c-=v;
         sum+=v;
         ans++;
         if(c<=0)break;
         if(v+a<=v1)v+=a;
         else
          v=v1;
       }
       System.out.println(ans);
       

     }
    catch(Exception e){
        e.printStackTrace();}

  }
  
  
}