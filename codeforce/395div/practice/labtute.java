import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
class Main
{

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
         
        public FastReader ()
        {
            
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        
        
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int iint()
        {
            return Integer.parseInt(next());
        }
 
        long ilong()
        {
            return Long.parseLong(next());
        }
 
        double idouble()
        {
            return Double.parseDouble(next());
        }
 
        String readline()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }        
    }
 
 
 public static void main(String[] args)
    {
        FastReader s=new FastReader();
        String[] sub={"Kcs602","Kcs603","Kcs604","Kcs605"};
        String[] techname={"RD","Rs","Bpc","Abh"};
    
        
        HashSet<String> lab=new HashSet<>();
        HashSet<String> tute1=new HashSet<>();
        HashSet<String> tute2=new HashSet<>();
        
        // for lab1 and tute2
        lab.add(sub[0]);
        System.out.println("lab1 "+sub[0]);
        if(!tute2.add(sub[1])){
            if(!tute2.add(sub[2])){
                tute2.add(sub[3]);System.out.println(sub[3]);
            }
            else
                System.out.println(sub[2]);
        } 
        else
            System.out.println(sub[1]);
        if(!tute2.add(sub[1])){
            if(!tute2.add(sub[2])){
                tute2.add(sub[3]); System.out.println(sub[3]);
            }
            else
                System.out.println(sub[2]);
        } 
        else
                System.out.println(sub[1]);


   
        //for lab2 and tute1
        lab.add(sub[1]);
        System.out.println("lab2 "+sub[1]);
        if(!tute1.add(sub[2])){
            if(!tute1.add(sub[3])){
                tute1.add(sub[0]);System.out.println(sub[0]);
            }
            else
            System.out.println(sub[3]);
        }
        else
        System.out.println(sub[2]); 
        if(!tute1.add(sub[2])){
            if(!tute1.add(sub[3])){
                tute1.add(sub[0]);System.out.println(sub[0]);
            }
            else
            System.out.println(sub[3]);
        } 
        else
        System.out.println(sub[2]); 
    


        // for lab1 and tute 2
       lab.add(sub[2]);
        System.out.println("lab1 "+sub[2]);
        if(!tute2.add(sub[1])){
            if(!tute2.add(sub[0])){
                tute2.add(sub[3]);System.out.println(sub[3]);
            }
            else
                System.out.println(sub[0]);
        } 
        else
            System.out.println(sub[1]);
        if(!tute2.add(sub[1])){
            if(!tute2.add(sub[0])){
                tute2.add(sub[3]); System.out.println(sub[3]);
            }
            else
                System.out.println(sub[0]);
        } 
        else
                System.out.println(sub[1]);


            //for lab2 and tute1
        lab.add(sub[3]);
        System.out.println("lab2 "+sub[1]);
        if(!tute1.add(sub[2])){
            if(!tute1.add(sub[1])){
                tute1.add(sub[0]);System.out.println(sub[0]);
            }
            else
            System.out.println(sub[1]);
        }
        else
        System.out.println(sub[2]); 
        if(!tute1.add(sub[2])){
            if(!tute1.add(sub[1])){
                tute1.add(sub[0]);System.out.println(sub[0]);
            }
            else
            System.out.println(sub[1]);
        } 
        else
        System.out.println(sub[2]); 
     System.out.println("lab 1:"+sub[0]);
     System.out.println("lab 2:"+sub[1]);
     System.out.println("lab 1:"+sub[2]);
     System.out.println("lab 2:"+sub[3]);


    }
}