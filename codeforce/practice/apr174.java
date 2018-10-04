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

    
          
        int iint()
        {
            return Integer.parseInt(next());
        }
    }
    static class Edgewight{
         Integer edge;
         Long weight;
         Edgewight(Integer edge,Long weight)
         {
            this.edge=edge;
            this.weight=weight;
         }
         @Override
         public boolean equals(Object o)
         {
          if(o instanceof Edgewight)
          { 
            Edgewight ew=(Edgewight)o;
            return this.edge==ew.edge;
          }
          return false;
         }
         
    }
    static class Customcomparator implements Comparator<Pair<Long,Integer>>
    {
        @Override
         public int compare(Pair<Long,Integer> o1,Pair<Long,Integer> o2) {      
        
        return o1.getKey().compareTo(o2.getKey());
     }   
    }
 public static void main(String[] args) {
        FastReader s=new FastReader();
         int t=s.iint();
         while(t-->0){
        Integer N=s.iint();
        Integer K=s.iint();
        Long X=s.ilong();
        Integer M=s.iint();
        Integer S=s.iint();
        
        ArrayList[] adj=new ArrayList[N];
        for (int i=0;i<(int)N ;i++ ) {
           adj[i]=new ArrayList<Edgewight>();
        }
        for(int i=0;i<(int)K-1;i++)
        {
            for (int j=i+1;j<(int)K ;j++ ) {
               adj[i].add(new Edgewight(j,X));
               adj[j].add(new Edgewight(i,X)); 
            }
            
        }
        int a,b;
        long c;
        
        for (int i=0;i<M;i++ ) {
           
           a=s.iint();
           b=s.iint();
           c=s.ilong();
           a--;
           b--;
           //System.out.println(a+" "+b);
           adj[a].add(new Edgewight(b,c));
           adj[b].add(new Edgewight(a,c));
           
        }
        
        /*
        for (int i=0;i<N ;i++ ) {
            System.out.println(i);
            for (int j=0;j<adj[i].size() ;j++ ) {
                Edgewight ew=(Edgewight)adj[i].get(j);
                System.out.println(ew.edge+" "+ew.weight);
            }

        }
                
       */
        //dijkstra algorithm
       
        long[] dist=new long[N];
        long max=Long.MAX_VALUE;
       
        Arrays.fill(dist,max);
        dist[(int)S-1]=0L;
       
        PriorityQueue pq=new PriorityQueue<Pair<Long,Integer>>(new Customcomparator());
        for (int i=0;i<N ;i++ ) {
            Pair p=new Pair<Long,Integer>(dist[i],i);
            pq.add(p);
        }
        long count=0L;
       
        while(!pq.isEmpty())
        {
            
             count++;

            Pair pr=(Pair)pq.peek();
            pq.remove();
            //System.out.println(pr.getKey()+" "+pr.getValue());
            int sz=adj[(int)pr.getValue()].size();
             for(int i=0;i<sz;i++)
             {
                Edgewight ew=(Edgewight)adj[(int)pr.getValue()].get(i);
                if((long)ew.weight+(long)pr.getKey()<dist[(int)ew.edge])
                {

                    dist[(int)ew.edge]=(long)ew.weight+(long)pr.getKey();
                    //pq.remove(ew);
                    pq.add(new Pair<Long,Integer>(dist[(int)ew.edge],new Integer(ew.edge)));
                    
                    //System.out.println(dist[ew.edge]+" "+ew.edge);
                   


                }

             }
             if(count==N)
              break;
             
             
        }

 for (int i=0;i<N;i++ ) {
   System.out.print(dist[i]+" ");     
  }
       System.out.println();
        
        
}
        
}
}