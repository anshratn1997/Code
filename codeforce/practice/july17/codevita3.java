import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    static long max=1000001L;
    static long max1=12000000000L;
    static boolean prime[]=new boolean[(int)max];
    static ArrayList<Long> primelist=new ArrayList<>();
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     ArrayList<Long> list=new ArrayList<>();
     ArrayList<Long> cumm=new ArrayList<>();
     cumm.add(2L);
     PRIME();
     int j=1;
     for(long i=3;cumm.get(cumm.size()-1)<=max1;){
           for(long k=2;k<sqrt(cumm.get(cumm.size()-1)+i))
        
     }


 
    
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

    void PRIME(){
    Arrays.fill(prime,true);
    for (int p=2; p<max; p++)
    {
        if (prime[p] == true)
        {
           
            for (int i=p*2; i<max; i += p){
                
                   prime[i] = false;
                 }
 
        }
     }
     int count=0;
     for (long i=2;i<max ;i++ ) {
        if(prime[(int)i]){
           primelist.add(i);
           count++;
           }
     }
    // System.out.println(count);

  }  
} 