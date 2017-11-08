import java.io.*;
import java.util.*;
import java.math.*;

//public 
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
public static void main(String[] args) {
        
    
        FastReader s=new FastReader();
        int t=s.iint();
        while(t-->0)
        {
            
              
                int sum=0;
                String st=s.next();
                int n=st.length();
                  int a[]=new int[n];
                for (int i=0;i<n ;i++ ) {
                    Character ch=st.charAt(i);
                    a[i]=Integer.parseInt(ch.toString());
                    sum+=a[i];
                }
                ArrayList<Integer> ind=new ArrayList<>();
                for (int i=0;i<n-1 ;i++ ) {
                    int temp=sum-a[i];
                    if(temp%3==0 && a[n-1]%2==0)
                        ind.add(i);
                    
                }
                if(a[n-2]%2==0){
                    int temp=sum-a[n-1];
                    if(temp%3==0)
                        ind.add(n-1);
                }
                //for (int i=0;i<ind.size() ;i++ ) {
                //System.out.print(ind.get(i)+" ");
               // }
               // System.out.println();
                int remove=-1;
                if(ind.size()==1)
                    remove=ind.get(0);
                else{
                 for (int i=0;i<ind.size()-1 ;i++ ) {
                   int index=ind.get(i);

                   if(a[index+1]>a[index])
                    {remove=index;break;}
                   else{
                    if(i==ind.size()-2){
                        remove=ind.get(ind.size()-1);
                    }
                   }


                }
            }
            if(remove==-1)
               {
                System.out.println("-1");
                continue;
               }
                for (int i=0;i<n ;i++ ) {
                    if(i!=remove)
                    System.out.print(a[i]);
                }
                System.out.println();


        }
    
}
}