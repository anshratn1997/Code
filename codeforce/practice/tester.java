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
long modInverse(long a, long m)
{
    long m0 = m, t, q;
    long x0 = 0L, x1 = 1L;
 
    if (m == 1)
      return 0;
 
    while (a > 1)
    {
        // q is quotient
        q = a / m;
 
        t = m;
 
        // m is remainder now, process same as
        // Euclid's algo
        m = a % m;a = t;
 
        t = x0;
 
        x0 = x1 - q * x0;
 
        x1 = t;
    }
 
    // Make x1 positive
    if (x1 < 0)
       x1 += m0;
 
    return x1;
}
     
       
    }
 
 
 public static void main(String[] args)
    {
   
    long[] gang = {1, 2, 3, 1, 1, 1, 1, 5, 6, 1569, 1, 2, 3, 2, 1569, 3};
    Map<Long,Long> map = new HashMap<Long,Long>();
    for (Long nextLong : gang) {
        Long count = map.get(nextLong);
        if (count == null) {
            count = 1L;
        } else {
            count = count + 1;
        }
        map.put(nextLong, count);
    }

    Long mostRepeatedNumber = null;
    Long mostRepeatedCount = null;
    Set<Long>keys = map.keySet();
    for (Long key : keys) {
        Long count = map.get(key);
        if (mostRepeatedNumber == null) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        } else if (count > mostRepeatedCount) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        } else if (count == mostRepeatedCount && key < mostRepeatedNumber) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        }
    }

    System.out.println("Most repeated value is: " + mostRepeatedNumber);   
        

    }
}