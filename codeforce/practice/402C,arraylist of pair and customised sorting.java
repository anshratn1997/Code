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
    
    public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        int n = s.iint();`
        int k=s.iint();
         Integer[] a=new Integer[n];
         Integer[] b=new Integer[n];
          ArrayList<Pair<Integer,Integer>> l=new ArrayList<Pair<Integer,Integer>>();
         // Pair<Integer,Integer> pr=new Pair<Integer,Integer>(4,5);
         
         for (int i=0;i<n ;i++ ) {
             a[i]=s.iint();
         }
         for (int i=0;i<n ;i++ ) {
             b[i]=s.iint();
         }
        for (int i=0;i<n ;i++ ) {
            Integer diff=a[i]-b[i];
            Integer value=i;
            Pair<Integer,Integer> pr=new Pair<Integer,Integer>(diff,value);
            l.add(pr);
        }
        
        Collections.sort(l,new CustomComparator());
    
        Integer sum=0;
        int count_ve=0;
        int j=0;
        for(Pair pq:l){
            
            if((int)pq.getKey()<=0){
                sum+=a[(int)pq.getValue()];
                count_ve++;
            }
            else if(count_ve<k)
            {
                sum+=a[(int)pq.getValue()];
                count_ve++;
                
            }
            else {
                break;
            }
            j++;

        }
       
        for (int i=j;i<n ;i++ ) {
            Pair pq=(Pair)l.get(i);
            sum+=b[(int)pq.getValue()];
        }
        
    System.out.println(sum);
}
}