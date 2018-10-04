import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
class Main
{
    static int max=1000001;
    static int[] lpfr=new int[max];
    static boolean prime[]=new boolean[max];
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
       ArrayList<Pair<Pair<Long,Long>,Long > > generate(int n)
        {
            int curr=lpfr[n];
            int cnt=1;
           
            ArrayList<Pair<Pair<Long,Long>,Long > > node=new ArrayList<>();
            long sum=0;
            while(n>1){
                n=n/lpfr[n];
                if(curr==lpfr[n]){
                    cnt++;
                    continue;
                }
               Pair<Long,Long> pq=new Pair(curr,cnt);
               sum+=cnt;
               Pair<Pair<Long,Long>,Long> pqq=new Pair(pq,sum);
                node.add(pqq);
                curr=lpfr[n];
                cnt=1;
                //System.out.println(curr);
            }
            
                //System.out.println(node.get(node.size()-1).getValue());
            return node;
        }
        
    }
    
 static ArrayList<Pair<Pair<Long,Long>,Long > > addmap(ArrayList<Pair<Pair<Long,Long>,Long > > node1,ArrayList<Pair<Pair<Long,Long>,Long > > node2)
 {
     ArrayList<Pair<Pair<Long,Long>,Long > > node3=new ArrayList<>();
     // int mn=Math.min(node1.get(0),getKey().getValue(),node2.get(0),getKey().getValue();
     int i=0,j=0;
     long sum=0;
     while(i<node1.size() && j<node2.size()){
         if(node1.get(i).getKey().getKey()==node2.get(j).getKey().getKey()){
             Pair<Long,Long> pq=new Pair(node1.get(i).getKey().getKey(),node1.get(i).getKey().getValue()+node2.get(j).getKey().getValue());
            sum+=node1.get(i).getKey().getValue()+node1.get(i).getKey().getValue();
            Pair<Pair<Long,Long>,Long> pqq=new Pair(pq,sum);
             node3.add(pqq);  
             i++;j++;         
                      }
         else if(node1.get(i).getKey().getKey()<node2.get(j).getKey().getKey()){
             Pair<Long,Long> pq=new Pair(node1.get(i).getKey().getKey(),node1.get(i).getKey().getValue());
             sum+=node1.get(i).getKey().getValue()+node1.get(i).getKey().getValue();
             Pair<Pair<Long,Long>,Long> pqq=new Pair(pq,sum);
             node3.add(pqq); 
             i++;
         }
         else{
             Pair<Long,Long> pq=new Pair(node1.get(j).getKey().getKey(),node1.get(j).getKey().getValue());
             sum+=node1.get(j).getKey().getValue()+node1.get(j).getKey().getValue();
             Pair<Pair<Long,Long>,Long> pqq=new Pair(pq,sum);
             node3.add(pqq); 
             j++;
         }            
     }
     while(i!=node1.size()){
        Pair<Long,Long> pq=new Pair(node1.get(i).getKey().getKey(),node1.get(i).getKey().getValue());
            sum+=(long)node1.get(i).getKey().getValue();
            Pair<Pair<Long,Long>,Long> pqq=new Pair(pq,sum);
             node3.add(pqq);  
             i++;
     }
     while(j!=node2.size()){
             Pair<Long,Long> pq=new Pair(node1.get(i).getKey().getKey(),node1.get(i).getKey().getValue());
             sum+=node1.get(i).getKey().getValue();
             Pair<Pair<Long,Long>,Long> pqq=new Pair(pq,sum);
             node3.add(pqq);  
             j++;
     }
 return node3;
  }    
   
static void PRIME(){
    Arrays.fill(prime,true);
    lpfr[0]=1;
    lpfr[1]=1;
    for (int p=2; p<max; p++)
    {
        if (prime[p] == true)
        {
           lpfr[p]=p;
            for (int i=p*2; i<max; i += p){
                if(prime[i]!=false){
                   lpfr[i]=p;}
                   prime[i] = false;}
 
        }
     }
   }

 
 public static void main(String[] args)
    {
        FastReader s=new FastReader();
        PRIME();
        ArrayList<Pair<Pair<Long,Long>,Long > > node1=new ArrayList<>();
        node1.add(new Pair(new Pair(2,3),0));
        node1.add(new Pair(new Pair(7,1),1));

        ArrayList<Pair<Pair<Long,Long>,Long > > node2=new ArrayList<>();
        node1.add(new Pair (new Pair(5,2),0));
        node1.add(new Pair(new Pair(9,1),1));

        ArrayList<Pair<Pair<Long,Long>,Long > > node3=addmap(node1,node2);
        for (int i=0;i< node3.size();i++ ) {
            System.out.println(node3.get(i).getKey().getKey());
        }
        
    }
}

