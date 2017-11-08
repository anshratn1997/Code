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
             int a=s.iint();
             int b=s.iint();
             String str=s.next();
             int l=0,r=0,u=0,d=0;
             boolean ans=true;

             for (int i=0;i<str.length() ;i++ ) {
                 if(str.charAt(i)=='L')
                    {
                        l++;
                       if (l+r>b || (l>b-1 || r>b-1)) {
                            ans=false;
                            System.out.println("1");
                            break;
                        }
                        
                    }
                  else if(str.charAt(i)=='R')
                    {
                        r++;
                        if (l+r>b || (l>b-1 || r>b-1)) {
                           ans=false;
                           System.out.println("2");
                           break;
                        }
                        
                    }
                else if(str.charAt(i)=='U')
                    {
                        u++;
                        if (u+d>a ||(u>a-1 || d>a-1)) {
                          ans=false;
                            System.out.println("3");
                          break;  

                        }
                       
                    }
                 else
                    {
                         d++;
                        if (u+d>a && (u>a-1 && d>a-1)) {
                           ans=false;
                           System.out.println(i);
                           break;
                        }
                        
                    }
             }
              if(ans)
                System.out.println("safe");
              else
                System.out.println("unsafe");
             
        }
          
}
}