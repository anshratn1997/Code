import java.io.*;
import java.util.*;
import java.math.*;
 class M
{

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
         
        public FastReader ()
        {
            try{
            br = new BufferedReader(new
                     InputStreamReader(new FileInputStream("input.txt")));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
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
          String message=s.readline(); 
          String[] msgword=message.split(" ");
          int i=0;
          for(String word: msgword) {
                 if(word.equals("Rs"))
                    break;
                 i++;
              }
          System.out.println(msgword[i+1]);
       }


    }
