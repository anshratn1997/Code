import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
public class Main
{

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
         
        public FastReader()
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

        int digit(int n)
        {
            int d=0;
            while(n>0)
            {n/=10;
                d++;

            }
            return d;
        }
         

    }
 static class CustomComparator implements Comparator<Pair<Integer,Integer>>
{
    @Override
    public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2) {      
        
        return o1.getKey().compareTo(o2.getKey());
    }   
}
static class CustomComparator1 implements Comparator<Pair<Integer,Integer>>
{
    @Override
    public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2) {      
        
        return o1.getValue().compareTo(o2.getValue());
    }   
}
    
    public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        int n= s.iint();
        ArrayList<Pair<Integer,Integer>> al1=new ArrayList<Pair<Integer,Integer>>(n);
        
         Integer l1,r1,l2,r2;
         for (int i=0;i<n ;i++ ) {
             l1=new Integer(s.iint());
             r1=new Integer(s.iint());
             Pair<Integer,Integer> pr=new Pair<Integer,Integer>(l1,r1);
            al1.add(pr);
         }
         int m=s.iint();
         ArrayList<Pair<Integer,Integer>> al2=new ArrayList<Pair<Integer,Integer>>(m);

         for (int i=0;i<m ;i++ ) {
             l2=new Integer(s.iint());r2=new Integer(s.iint());
             Pair<Integer,Integer> pr=new Pair<Integer,Integer>(l2,r2);
             al2.add(pr);
         }
     Collections.sort(al1,new CustomComparator1());
     Collections.sort(al2,new CustomComparator());
     int diff1=0;//al2.get(m-1).getKey()-al1.get(0).getValue();
     int max1=0;
        for(int i=m-1;i>=0;i--)
        {
            diff1=al2.get(i).getKey()-al1.get(0).getValue();
            if(diff1>0 && max1<al2.get(i).getValue()-al1.get(0).getValue())
                max1=al2.get(i).getValue()-al1.get(0).getValue();
        }
        int max2=0;
     Collections.sort(al1,new CustomComparator());
     Collections.sort(al2,new CustomComparator1());
     int diff2=0;//al1.get(0).getKey()-al2.get(m-1).getValue();
     for(int i=-1;i>=0;i--)
     {
        diff2=al1.get().getKey()-al2.get(-1).getValue();
     }
     if(diff1>0 || diff2>0)
        System.out.println(Math.max(diff2,diff1));
     else
        System.out.println("0");
        
}
}