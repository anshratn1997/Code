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
        StringBuffer match(StringBuffer sb)
        {
             int len=sb.length();
             StringBuffer ret=new StringBuffer("");
             for (int i=0;i<sb.length();i++ ) {
                char ch='0';
                   if(sb.charAt(i)!=ch)
                ret.append(sb.charAt(i));
             }
             //System.out.println(ret.substring(0,l));
             return ret;
        }
    boolean KMPSearch(StringBuffer pat, StringBuffer txt,FastReader st)
    {
        int M = pat.length();
        int N = txt.length();
         boolean ans=false;
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]
 
        // Preprocess the pattern (calculate lps[]
        // array)
        st.computeLPSArray(pat,M,lps);
       
        int i = 0;  // index for txt[]
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                //System.out.println("Found pattern "+"at index " + (i-j));
                ans=true;

                j = lps[j-1];
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        return ans;
    }
    void computeLPSArray(StringBuffer pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0
 
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];
 
                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    }
 

    public static void main(String[] args)
    {
        FastReader s=new FastReader();
        StringBuffer s1=new StringBuffer(s.next());
        int l1=s1.length();
        StringBuffer s2=new StringBuffer(s.next());
        int l2=s2.length();
        int[] arr=new int[l1];
        for (int i=0;i<l1;i++ ) {
             arr[i]=s.iint();    
        }
        int ans=0;
        for(int i=0;i<l1;i++)
        {
            StringBuffer sb=new StringBuffer(s.match(s1));
            int ll1=sb.length();
           // System.out.println(s.KMPSearch(s2,s1,s));
            if(s.KMPSearch(s2,sb,s))
             {
                s1.replace(arr[i]-1,arr[i],"0");
                ans++;
                continue;
             }
            else {
               break;
            }
        }
        System.out.println(ans-1);
       
        
    }
}