import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class hc1 {

    public static void main(String[] args) throws IOException {
        
       Scanner br=new Scanner(System.in);
       
       HashMap<String ,Integer> ll = new HashMap<>();
      
       int n=br.nextInt();
       br.nextLine();
       for (int i=0;i<n ;i++ ) {
           String st=br.nextLine();
            int p=br.nextInt();
            br.nextLine();
            ll.put(st,p);
       }    
       while(br.hasNext())
       {
          String s=br.nextLine();
          try{
          int out=ll.get(s);
          System.out.println(s+"="+out);
         }
         catch(Exception e)
         {
            System.out.println("Not found");
         }

       }
         
       }
    }