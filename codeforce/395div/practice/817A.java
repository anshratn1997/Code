import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
//public 
class  Main{
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     int a[]=new int[n];
     String line[]=br.readLine().split(" ");
     for (int i=0;i<n ;i++ ) {
         a[i]=Integer.parseInt(line[i]);
     }
     Arrays.sort(a);
     int min=a[0]+a[1]+a[2];
     int[] freq=new int[3];
     freq[0]=1;
     freq[1]=1;
     freq[2]=1;
     int j=0;int match=a[0];
     for (int i=1;i<n && j< 3;i++ ) {
           if(a[i]==match)
              freq[j]++;
           else
           {
            match=a[i];
            j++;
           }
     }
     int total=3;
     int t=0;
     long temp[]=new long[3];
     long count=0;
     while(total>0){
        if(freq[0]>=1){
            total-=freq[0];
            temp[0]=freq[0];
            freq[0]=0;
            t=0;
            //System.out.println("ok1");
        }
        else if(freq[1]>=1){
            total-=freq[1];
            temp[1]=freq[1];
            freq[1]=0;
            t=1;
            //System.out.println("ok2");
        }
        else if(freq[2]>=1)
        {
            total-=freq[2];
            temp[2]=freq[2];
            freq[2]=0;
            t=2;
            //System.out.println("ok3");
        }
     }
     //System.out.println(t);
     if(t==0)
        count+=(temp[0]*(temp[0]-1)*(temp[0]-2))/6;
     else if(t==1){
        //System.out.println("fd");
        if(temp[0]==1)
            count+=(temp[1]*(temp[1]-1))/2;
        else
            count+=temp[1];
       // System.out.println(temp[1]);
    }
    else
        count+=temp[2];
     System.out.println(count);
   }
    catch(Exception e){
        e.printStackTrace();
    }
  }

}