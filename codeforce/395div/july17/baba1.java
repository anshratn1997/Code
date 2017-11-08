import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    static long max=1000001L;
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     
     int temp[]=iint();
     int b=temp[0];
     int t=temp[1];
    int num=1;
    int sum=0;
    int ans=0;
    while(true){
        int i=0;
        sum=0;
       for ( i=1 ;i<=t;i++ ) {
           sum=sumofdigit(num+i);
           Integer dividend=Integer.parseInt(convert(sum,b));
           int numerator=con_ten(num+i,b);
           int denominator=con_ten(dividend,b);
           if(numerator%denominator==0)
             {
              sum=0;

             }
             else
              break;

       }
       if(i==t-1)
         {
           Integer dividend1=Integer.parseInt(convert(num,b));
           Integer dividend2=Integer.parseInt(convert(num+t+1,b));
           int numerator1=con_ten(num,b);
           int numerator2=con_ten(num+t+1,b);
           int denominator1=con_ten(dividend1,b);
           int denominator2=con_ten(dividend2,b);
           if(numerator1%denominator1!=0 && numerator2%denominator2!=0){
             ans=num+1;
             break;
           }
           
         }
         num++;
      
     }
    System.out.println(ans);
 
    
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
 String convert(int number, int base)
{
    int quotient = number / base;
    int remainder = number % base;

    if (quotient == 0) // base case
    {
        return Integer.toString(remainder);      
    }
    else
    {
        return convert(quotient, base) + Integer.toString(remainder);
    }            
}
int sumofdigit(int num)
{
  int sum=0;
    while(num!=0){
       sum=sum+num%10;
       num=num/10;
    }
    return sum;
}
int con_ten(int num,int base){
  int count=0;
   int res=0;
   while(num!=0){
    int digit=num%10;
     res=res+digit*(int)Math.pow(base,count);
      num=num/10;
      count++;
   }
   return res;

}
  
   //input method
    int[] iint() throws IOException{
      String line[]=br.readLine().split(" ");
      int[] a=new int[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Integer.parseInt(line[i]);
      }
      return a;
    }
    long[] ilong() throws IOException{
      String line[]=br.readLine().split(" ");
      long[] a=new long[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    double[] idouble() throws IOException{
      String line[]=br.readLine().split(" ");
      double[] a=new double[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    long li() throws IOException{
      
      return Long.parseLong(br.readLine());
    }
    int ii() throws IOException{
      
      return Integer.parseInt(br.readLine());
    }
    double di() throws IOException{
      return Double.parseDouble(br.readLine());
    }
    char ci() throws IOException{
      return (char)br.read();
    }
    String si() throws IOException{
       return br.readLine();
    }
}


    