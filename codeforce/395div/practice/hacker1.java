import java.io.*;
import java.util.*;
import java.math.*;
public class  hacker1{
    static long ass[]=null;
    static int maxindex[]=null;
    static long mod=1000000007;
    public static void main(String[] args) {
    new hacker1().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int t=Integer.parseInt(br.readLine());
     while(t-->0){
     int n=Integer.parseInt(br.readLine());
     int arr[]=new int[n];
       ass=new long[n];
       maxindex=new int[n];
     String line[]=br.readLine().split(" ");
     for (int i=0;i<n ;i++ ) {
         arr[i]=Integer.parseInt(line[i]);
     }
     int m_i=arr[n-1],loc=n-1;
      maxindex[n-1]=loc;
     for (int i=n-2;i>=0;i-- ) {
         if(arr[i]>=m_i)
         {
            loc=i;
            m_i=arr[i];
            maxindex[i]=i;
         }
         else
            maxindex[i]=loc;

     }
//     for (int i=0;i<n ;i++ )
  //     System.out.print(maxindex[i]+" "); 
     ass[n-1]=1;
     //cumm[n-1]=1;
     for (int i=n-2;i>=0 ;i-- ) {
         countway(arr,n,i);
     }
    // for (int i=0;i<n ;i++ ) 
      //   System.out.print(ass[i]+" ");
     if(n==1)
        System.out.println("1");
     else{
        int location=maxindex[0];
        //System.out.println("ffg"+location);
        if(location!=n-1)
           System.out.println((ass[location+1]+1)%mod);
         else
        System.out.println("1");
        }
      }
   }
    catch(Exception e){
        e.printStackTrace();

    }

  }
  void countway(int[] arr,int n,int j){
      int location=maxindex[j];
      //System.out.println(location+" "+arr[location]+" "+j);
      int temp=location;
      int res=0;/*
      while(temp!=n-1)
      {
         res+=ass[temp+1];
         temp++;
      }*/
     if(temp!=n-1){
     ass[j]=(ass[temp+1]+1)%mod;
     ass[j]=(ass[j]+ass[j+1])%mod;
      }
    else
      ass[j]=(ass[j+1]+1)%mod;
     }
}