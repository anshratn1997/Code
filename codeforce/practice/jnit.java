import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
//public
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
        HashMap<String,Integer> tute1=new HashMap<>();
        tute1.put("Kcs602",0);
        tute1.put("Kcs603",0);
        tute1.put("Kcs604",0);
        tute1.put("Kcs605",0);
        HashMap<String,Integer> tute2=new HashMap<>();
        tute2.put("Kcs602",0);
        tute2.put("Kcs603",0);
        tute2.put("Kcs604",0);
        tute2.put("Kcs605",0);
        HashMap<String,Integer> lab1=new HashMap<>();
        lab1.put("Kcs602",0);
        lab1.put("Kcs603",0);
        lab1.put("Kcs604",0);
        lab1.put("Kcs605",0);
        HashMap<String,Integer> lab2=new HashMap<>();
        lab2.put("Kcs602",0);
        lab2.put("Kcs603",0);
        lab2.put("Kcs604",0);
        lab2.put("Kcs605",0);
         HashSet<String> set=new HashSet<>();
         set.add("Kcs602");
         while(true){
        if(lab1.get(sub[0])==0||lab2.get(sub[0])==0){
                 int t=5;
                if(lab1.get(sub[0])==0){
                    while(t-->0){
                        double d=Math.random()*3;
                      int index1=(int)d;

                      System.out.println(index1);
                      System.out.println(set.contains(sub[index1]));       
                      if(!set.contains(sub[index1])){
                          if(tute2.get(sub[index1])==0){
                            System.out.println("tute2 "+sub[index1]);
                             tute2.put(sub[index1],1);
                             set.add(sub[index1]);
                             break;
                          }
                       }
                    }
    }
}}
}
}
int count=0;
        int t2=0;
        int t1=0;
        while(true)
        {
            double rand=Math.random()*4;
            int index=(int)rand;
            HashSet<String> set=new HashSet<>();
            set.add(sub[index]);
           // System.out.println(sub[index]);
            if(lab1.get(sub[index])==0||lab2.get(sub[index])==0){
                if(lab1.get(sub[index])==0){
                    lab1.put(sub[index],1);
                     int local=0;
                    while(true){
                        double d=Math.random()*4;
                      int index1=(int)d;
                       local++;
             //         System.out.println("tute2 1"+index1);
                       
                      if(!set.contains(sub[index1])){
                         
                          if(tute2.get(sub[index1])==0){
                            System.out.println("tute2 1"+sub[index1]);
                             tute2.put(sub[index1],1);
                             set.add(sub[index1]);
                             t1++;
                             count++;
                             break;
                          }
                       }
                       if(t1==4)
                        break;
                         if(local==20)
                            break;

                    }
                    if(count==8)
                        break;
                    
                    local=0;
                    while(true){
                       double d=Math.random()*4;
                      int index2=(int)d;
               //       System.out.println("tute2 2"+index2);
                      local++;
                      if(!set.contains(sub[index2])){
                          if(tute2.get(sub[index2])==0){
                            System.out.println("tute2 2"+sub[index2]);
                             tute2.put(sub[index2],1);
                             set.add(sub[index2]);
                             count++;
                             t1++;
                             break;
                          }
                       }
                       if(t1==4)
                        break;
                         if(local==20)
                            break;

                    }
                    if(count==8)
                        break;
                    set.clear();

                }
                else if(lab2.get(sub[index])==0){ 
                  
                    lab2.put(sub[index],1);
                     int local=0;
                    while(true){
                       double d=Math.random()*4;
                      int index1=(int)d;
                      local++;
                     
                 //     System.out.println("tute1 1"+index1);
                      if(!set.contains(sub[index1])){
                          if(tute1.get(sub[index1])==0){
                            System.out.println("tute1 1"+sub[index1]);
                             tute1.put(sub[index1],1);
                             set.add(sub[index1]);
                             count++; 
                             t2++;  
                             break;
                          }
                       }
                       if(t2==4)
                        break;
                      if (local==20) {
                          break;
                      }
                    }
                    if(count==8)
                        break;
                    local=0;
                    while(true){
                      double d=Math.random()*4;
                      int index2=(int)d;
                       local++;
                   //   System.out.println("tute1 2"+index2);
                      if(!set.contains(sub[index2])){
                          if(tute1.get(sub[index2])==0){
                            System.out.println("tute1 2"+sub[index2]);
                             tute1.put(sub[index2],1);
                             set.add(sub[index2]);
                             count++;
                             t2++;
                             break;
                          }
                       }
                       if(t2==4)
                        break;
                     if(local==20)
                        break;

                    }
                    if(count==8)
                        break;
                    set.clear();

                }


            }
            if(count==8)
                break;

        }
