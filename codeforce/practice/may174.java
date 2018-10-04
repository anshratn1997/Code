import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
class Main
{
    static int max=100001;
    static int[] seg=new int[4*100001];
    static int[] kframe=new int[max];
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

        void buid_tree(int nd,int a,int b,int[] arr){
              if(a>b)
                return;
            if(a==b)
            {
               seg[nd]=arr[a];
               return;
            }
            buid_tree(nd*2,a,(a+b)/2,arr);
            buid_tree(nd*2+1,1+(a+b)/2,b,arr);
            seg[nd]=Math.max(seg[nd*2+1],seg[nd*2]);
 
        }
        int get(int nd,int a,int b,int l,int r){
            if(a>b|| a>r || b<l){
                
                return 0;
            }
            if(a>=l && b<=r)
            {
               // System.out.println(a+" "+b+" "+nd);

                return seg[nd];
            }
            int q1=get(2*nd,a,(a+b)/2,l,r);
            int q2=get(2*nd+1,(a+b)/2+1,b,l,r);
            return Math.max(q1,q2);
        }
    }
    
 public static void main(String[] args) {
        FastReader s=new FastReader();
        int n=s.iint(),k=s.iint(),p=s.iint();
        int a[]=new int[2*n];
        int n_1=-1;
        for (int i=0;i<n ;i++ ) {
            a[i]=s.iint();
            a[n+i]=a[i];
        }
        String query=s.next();
        kframe[0]=a[0];
      System.out.print(kframe[0]+" ");
        for (int i=1;i<Math.min(k,n) ;i++ ) {
            kframe[i]=kframe[i-1]+a[i];
           System.out.print(kframe[i]+" ");
            n_1=Math.max(n_1,kframe[i]);
        }
        for (int i=k;i<2*n ;i++ ) {
            kframe[i]=kframe[i-1]+a[i]-a[i-k];
            System.out.print(kframe[i]+" ");
             n_1=Math.max(n_1,kframe[i]);
        }
        int shift=0;  
        s.buid_tree(1,0,2*n-1,kframe);
        for (int i=0;i<p ;i++ ) {
              if(query.charAt(i)=='?'){
               int l=shift+Math.min(k,n)-1;
               int r=shift+n-1;
              // System.out.println(l+" "+r);
               System.out.println(s.get(1,0,2*n-1,l,r));
             }
              else{
                shift++;
                shift=shift%n;

              }
          } 
          
   }
}