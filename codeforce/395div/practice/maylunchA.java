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
        int minflip(String str,int even_odd)
        {
           // System.out.println(str);
            int l=str.length();
            int i=0;
            if(l!=0){
            if(even_odd%2!=0){
            for (l=str.length()-1;l>=0 ;l-- ) {
              if(str.charAt(l)=='0'){
                continue;
            }
            else 
                break;     
           }
            if(l+1==0)
                return minflip(str.substring(0,i),even_odd+1);
            for (i=l;i>=0 ;i-- ) {
                if(str.charAt(i)=='1')
                    continue;
                else
                    break;
            }
           }
           else
           {
             for (l=str.length()-1;l>=0 ;l-- ) {
                if(str.charAt(l)=='1'){
                continue;
            }
            else 
                break;     
           }
           
            for (i=l;i>=0 ;i-- ) {
                if(str.charAt(i)=='0')
                    continue;
                else
                    break;
            }
           }
            return minflip(str.substring(0,i+1),even_odd+1)+1;
              }
              else
              return 0;
             }
                
    }
 
 
 public static void main(String[] args)
    {
        FastReader s=new FastReader();
        String str=s.next();
        int count_flip=s.minflip(str,1);
        System.out.println(count_flip);      
        

    
    }
}