import java.util.*;
import java.io.*;
//public 
class Main{
   public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    PrintWriter o=new PrintWriter(System.out);
    int n=sc.nextInt();
    long a[]=new long[n];
    for (int i=0;i<n ;i++ ) {
      a[i]=sc.nextLong();      
    }
    long left[]=new long[n];
    long right[]=new long[n];
    left[0]=0L;
    right[n-1]=0L;

    for(int i=1;i<n;i++)
    {
        
          left[i]=a[i-1]+left[i-1]+1-a[i];
          if(left[i]<0)
            left[i]=0;
        
    }
    for(int i=n-2;i>=0;i--)
    {
        
          right[i]=a[i+1]+right[i+1]+1-a[i];
        if(right[i]<0)
          right[i]=0;
        

    }
    long ttt[]=new long[n];
    for(int i=0;i<n;i++){
      ttt[i]=Math.min(a[i]+left[i],a[i]+right[i]);
    }
    boolean inc=false;
    for(int i=1;i<n;i++){
      if(ttt[i]==ttt[i-1]){
         inc=true;
         break;}
    }
     for(int i=1;i<n;i++)
        left[i]=left[i]+left[i-1];

        
    
     for(int i=n-2;i>=0;i--)
          right[i]=right[i]+right[i+1];

    
   // for (int i=0;i<n ;i++ ) {
   //   System.out.println(left[i]+" "+right[i]);
    //}
      long  max=Long.MAX_VALUE;
    if(n==1){
      System.out.println("0");
    }
    else{
    for(int i=0;i<n;i++)
    {
      long temp=0L;
      if(i==0){
         temp=Math.min(left[0]+right[1],right[0]);
         //System.out.println(i+" "+temp);

         max=Math.min(temp,max);
      }
      else if(i==n-1){
        temp=Math.min(left[n-1],right[n-1]+left[n-2]);
        //System.out.println(i+" "+temp);
        max=Math.min(temp,max);
      }
      else{
        temp=Math.min(left[i]+right[i+1],left[i-1]+right[i]);
        //System.out.println(i+" "+temp);
        max=Math.min(temp,max);
      }
    }
    if(inc)
      o.println(max+1);
    else
    o.println(max);
    o.flush();
    o.close();
   }}
}