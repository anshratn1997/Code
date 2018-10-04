import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
public class  Main{
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     String time=br.readLine();
    char ch1[]=new char[1];ch1[0]=time.charAt(0);
    char ch2[]=new char[1];ch2[0]=time.charAt(1);
    char ch3[]=new char[1];ch3[0]=time.charAt(3);
    char ch4[]=new char[1];ch4[0]=time.charAt(4);
    
     int d1=Integer.parseInt(new String(ch1));

     int d2=Integer.parseInt(new String(ch2));  
     // System.out.println(d1);
     int d3=Integer.parseInt(new String(ch3));
     int d4=Integer.parseInt(new String(ch4));


     int num1=d1*10+d2;
     int num2=d3*10+d4;

     int ans=0;
    if(num1==9)
        ans=61-num2;
    else if(num1==19) 
        ans=62-num2;
    else if(num1==23){
        if(num2<=32)
            ans=32-num2;
        else
            ans=60-num2;
    }
    else{
        int rev1=d2*10+d1;
        if(rev1>=num2)
            ans=rev1-num2;
        else
            ans=60-num2+(d2+1)*10+d1;    
        //System.out.println((d2+1)*10+d1);
      }
    System.out.println(ans);
   }
  catch(Exception e){

    }
  } 
}



 
    