//PROBLEM A SOLUTION


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
       
        int row=-1,col=-1;
        int arr[][]=new int[5][5];
        for (int i=0;i<5 ;i++ ) {
            for (int j=0;j<5 ;j++ ) {
              arr[i][j]=s.iint();
              if(arr[i][j]==1){
                row=i;
                col=j;
            }
        }
    }
         System.out.println(Math.abs(col-2)+Math.abs(row-2));
         

       
}
}
 int Binarysearch(int a[],int size,int key){
int low=0,high=size-1;
boolean find=false;
int mid=0;
while(low<=high){
 mid=(high+low)/2;
if(key==a[mid]){
    find=true;
    break;
}
else if(key<a[mid])
    high=mid;
else
    low=mid+1;
}
if(find)
    return mid;
else
    return -1;
}