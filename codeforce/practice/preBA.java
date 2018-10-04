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
        int t=s.iint();
        while(t-->0)
        {
            String s_m=s.next();
            int len=s_m.length();
            char[] charsm1=s_m.toCharArray();
            char[] charsm2=s_m.toCharArray();
            int count1=0,count_m=0;
            int count2=0,count_s=0;
            for (int i=0;i<len ;i++ ) {
                if(charsm1[i]=='m')
                    count_m++;
                else
                    count_s++;

            }
            for (int i=0;i<len-1;i++ ) {
                if(charsm1[i]=='m' && charsm1[i+1]=='s')
                {
                    count1++;
                    charsm1[i]='?';charsm1[i+1]='?';
                }
                
            }
            for (int i=0;i<len-1;i++ ) {
                if(charsm1[i]=='s' && charsm1[i+1]=='m')
                {
                    count1++;
                    charsm1[i]='?';charsm1[i+1]='?';
                }
            }
            for (int i=len-1;i>0;i-- ) {
                if(charsm2[i]=='m' && charsm2[i-1]=='s')
                {
                    count2++;
                    charsm2[i]='?';charsm2[i-1]='?';
                }
            }
            for (int i=len-1;i>0;i-- ) {
                if(charsm2[i]=='s' && charsm2[i-1]=='m')
                {
                    count2++;
                    charsm2[i]='?';
                    charsm2[i-1]='?';
                }
            }
           
            if(count_s-Math.max(count1,count2)>count_m)
                System.out.println("snakes");
            else if(count_s-Math.max(count1,count2)<count_m)
                System.out.println("mongooses");
            else
                System.out.println("tie");
            
        }
        


    }
}