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
        int n=s.iint();
        int m=s.iint();
        
        ArrayList<Pair<Integer,Integer> > al=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          int a=s.iint();
            Pair pq=new Pair(a,i);
            al.add(pq);
        }
        for (int i=0;i<m ;i++ ) {
            int l=s.iint();
            int r=s.iint();
            int x=s.iint();
            //PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>(new CustomComparator());
            HashMap<Integer,Integer> sm=new HashMap<>();
            for (int j=l-1;j<r ;j++ ) {
               sm.put(al.get(j).getKey(),al.get(j).getValue());
                
            }
           
            Map<Integer,Integer> map = new TreeMap<Integer,Integer>(sm);
            Map.Entry me2=(Map.Entry)map.get(x-l+1);
            boolean ans=false;
          //  if(map.get(x-l+1).getKey()==al.get(x-1).getKey() && map.get(x-l+1).getValue()==al.get(x-1).getValue())
            //         ans=true;

            if (ans) {
                System.out.println("Yes");
            }
            else
                System.out.println("No");

        }

    }
}