import java.io.*;
import java.util.*;
import java.math.*;
//public 
class digits{
    
    
    BufferedReader br;
    
    public static void main(String[] args) {
    new digits().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     long n=li();
     ArrayList<Long> digit=new ArrayList<Long>();
     Stack<Long> st=new Stack<Long>();
     while(n!=0)
     {
        long rem=n%10;
        n=n/10;
        
        st.push(rem);
     }
     while(!st.empty())
      {
        digit.add(st.pop());
      }
     ArrayList<Long> al=new ArrayList<>();
     boolean find=false;
     Stack<Long> st1=new Stack<>();
     st1.push(digit.get(0));
     for (int i=1;i<digit.size() ;i++ ) {
           //st1.push(digit.get(i));
            st1.push(digit.get(i));
          if(digit.get(i)<digit.get(i-1))
          {
              int l=i-1;
              st1.pop();
              for (;l>=0 ;l-- ) {
                     if(digit.get(l)!=digit.get(i-1)){
                          break;
                     }
                     if(!st1.empty()){
                       st1.pop();
                      // System.out.println("gff");
                     }
              }
              l++;
              //System.out.println(l+" idfio");
              st1.push(digit.get(l)-1);
              for (int k=l+1;k<digit.size() ;k++ ) {
                
                 long num=Long.parseLong("9");
                        st1.push(num);
                  find=true;
              }
              if(find)
                break;

          }
          

     }
     ArrayList<Long> al1=new ArrayList<Long>();
     while(!st1.empty())
      {
        al1.add(st1.pop());
      }
     StringBuffer sb=new StringBuffer("");
     for (int i=al1.size()-1;i>=0 ;i-- ) {
       //System.out.print(al1.get(i));
       sb.append(al1.get(i).toString());
     }
     System.out.println(Long.parseLong(sb.toString()));
   
   
   
    
        
   }
     
     
     
  
    catch(Exception e){
        e.printStackTrace();}
    
  }
  
  


   //input method
    int[] iint() throws IOException{
      String line[]=br.readLine().split(" ");
      int[] a=new int[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Integer.parseInt(line[i]);
      }
      return a;
    }
    long[] ilong() throws IOException{
      String line[]=br.readLine().split(" ");
      long[] a=new long[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    double[] idouble() throws IOException{
      String line[]=br.readLine().split(" ");
      double[] a=new double[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Long.parseLong(line[i]);
      }
      return a;
    }
    long li() throws IOException{
      
      return Long.parseLong(br.readLine());
    }
    int ii() throws IOException{
      
      return Integer.parseInt(br.readLine());
    }
    double di() throws IOException{
      return Double.parseDouble(br.readLine());
    }
    char ci() throws IOException{
      return (char)br.read();
    }
    String si() throws IOException{
       return br.readLine();
    }
}


    