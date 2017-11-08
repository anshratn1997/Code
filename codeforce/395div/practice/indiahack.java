import java.io.*;
import java.util.*;
import java.math.*;
public class  indiahack{
    public static void main(String[] args) {
    new indiahack().main1();

  }
  void main1()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     int a[]=new int[n];
     int count_1=0;
     String line[]=br.readLine().split(" ");
     boolean allzero=true;
     boolean allone=true;
     for (int i=0;i<n ;i++ ) {
        a[i]=Integer.parseInt(line[i]);
        if(a[i]==1){
          count_1++;
          allzero=false;
        }
        else
          allone=false;
     }
     if(allone||allzero)
      System.out.println("0");
    else
     System.out.println(flipbits(a,n,count_1));
     }
    catch(Exception e){
        e.printStackTrace();

    }


  }
  int flipbits(int[] a,int n,int count_1){
    ArrayList<Integer> key=new ArrayList<>();
    ArrayList<Integer> value=new ArrayList<>();
    boolean onezero=false;
   /* if(a[0]==0){
      key.add(1);
      value.add(0);
      onezero=false;
    }*/
    int count=0;
    for (int i=0;i<n ;i++ ) {
        if(a[i]==1){
          if(onezero==true)
          {
            key.add(0);
            value.add(count);
            count=1;
            onezero=false;
          }
          else if(onezero==false){
          count++;
          continue;}
        }
        else{
          if(onezero==false)
          {
            key.add(1);
            value.add(count);
            count=1;
            onezero=true;
          }
          else if(onezero==true){
            count++;
          }
        }
    }
     if(a[n-1]==0){
      key.add(0);
      value.add(count);
      key.add(1);
      value.add(0);
     }
     else{
      key.add(1);
      value.add(count);
     }

   // for (int i=0;i<key.size() ;i++ ) {
     //  System.out.println(key.get(i)+" "+value.get(i));
    // }
     int ans=0;
     int max=0;
     int location=0;
     if(value.get(1)==1){
     max=value.get(0)+value.get(2);
     }
     else{
       max=Math.max(value.get(0),value.get(2));
    }

     
      //System.out.println(max);
     //System.out.println(location);
     for (int i=2;i<key.size()-2;i+=2 ) {
       if(value.get(i+1)==1)
        {
                 if(value.get(i)+value.get(i+2)>=max){
                    location=i;
                    max=value.get(i)+value.get(i+2);
                   // System.out.println(max);
                 }
         }
         else if(value.get(i+1)>1)
           {
            if(value.get(i)>=max)
            {
              max=value.get(i);
              location=i;
            }
           }  
     }
    //System.out.println(max);
    ans=max;
     if(max==count_1){
     // System.out.println("Fdsa");
      if(count_1==1)
        ans=max;
      else if(value.get(location)==0||value.get(location+2)==0)
         ans=max-1;}
     else{
      //System.out.println("dfasfsa");
          ans=max+1;}

     return ans;
  }
  
}