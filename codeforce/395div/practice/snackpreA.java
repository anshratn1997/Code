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
        int t=s.iint();
        while(t-->0){
        int n=s.iint();
        char[][] plate=new char[2][n];
        //char[] row1= new char[n];
        //char[] row2= new char[n];
        String s1=s.next();
        String s2=s.next();
        int count=0;
        int first_loc_row=-1,first_loc_col=-1;
        boolean first=false;

        for (int i=0;i<n ;i++ ) {
             plate[0][i]=s1.charAt(i);
             if(plate[0][i]=='#')
                count++;
             if(plate[0][i]=='#' && first==false)
                 {
                    first=true;
                    first_loc_row=0;
                    first_loc_col=i;
                 }
             plate[1][i]=s2.charAt(i);
             if (plate[1][i]=='#') {
                 count++;
             }
             if(plate[1][i]=='#' && first==false)
                 {
                    first=true;
                    first_loc_row=1;
                    first_loc_col=i;
                 }
        }
 
       boolean both_row=false;
      
       int start=-1;
       int times=0;
       if(first_loc_row==0){ 
           start=0;
          if(plate[first_loc_row][first_loc_col]=='#' && plate[first_loc_row+1][first_loc_col]=='#'){
              both_row=true;
              
          }
      }
      else{
          start=1;
      }
      int row=0;
      row=start;
      int temp=count;
      boolean ans1=true;
      boolean ans2=true;
      
      for (int i=first_loc_col;i<n ;i++ ) {
         
          if(count!=0){          
                       if(plate[row][i]=='#' &&  plate[(row+1)%2][i]=='#')
                        {
                             count-=2;
                             times++;
                             row=(row+1)%2;
                         }
                       else if(plate[row][i]=='#' && times%2==0){
                           count--;
                           
                       }
                       else if(plate[row][i]=='#' && times%2==1){
                        count--;
                        
                       }
                       else{
                       // System.out.println(i);
                        ans1=false;
                        break;}
                   
          }
          else{
           // System.out.println(i);
           
            break;}
          
      }
       //System.out.println(ans1);
      if(both_row)
      {
      count=temp;
      row=1;
      start=1;
      times=0;
      for (int i=first_loc_col;i<n ;i++ ) {
               if(count!=0){
                       if(plate[row][i]=='#' && plate[(row+1)%2][i]=='#')
                        {
                             count-=2;
                             times++;
                             row=(row+1)%2;
                         }
                       else if(plate[row][i]=='#' && times%2==0){
                           count--;
                           
                       }
                       else if(plate[row][i]=='#' && times%2==1){
                        count--;
                        
                       }
                       else{
                       // System.out.println(i);
                        ans2=false;
                        break;}
                   
               
          }
          else{
           // System.out.println("count :"+count);
            
            break;}
        }
      }
      //System.out.println(ans2);
      if(ans1)
        System.out.println("yes");
      else{
        if(ans2 && both_row )
        System.out.println("yes");
        else
            System.out.println("no");

      }
    }   
  }
}