import java.io.*;
import java.util.*;
import java.math.*;
//public 
class prime{
    
    static int max=1000001;
    
    static boolean prime[]=new boolean[max];
    ArrayList<Integer> primelist=new ArrayList<>();
   
    BufferedReader br;
    public static void main(String[] args) {
    new prime().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     //System.out.println(concantenate(11,12));
     
     int n=ii();
     PRIME();
     int index=0;
     //System.out.println(primelist.get(0));
     HashSet<Integer> set=new HashSet<>();
     if(n<=1)
      System.out.println(0);
     else{
     for(int i=0;i<100;i++){
       if(primelist.get(i)==n){index=i;break;}
       else if(primelist.get(i)>n){index=i-1;break;}
     }
     //System.out.println(index);
     int count=0;
     for(int i=0;i<=index;i++){
        for(int j=0;j<=index;j++){
           int con=concantenate(primelist.get(i),primelist.get(j));
            if(prime[con] && !set.contains(con)){
              count++;
              set.add(con);
            }
        }
     }
     System.out.println(count);}
  }
    catch(Exception e){
        e.printStackTrace();}
    
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
     
     for (int i=2;i<max ;i++ ) {
        if(prime[i]){
           primelist.add(i);
           
           }
     }
     //System.out.println(count);
   }
int concantenate( int a,int b){
  Integer a1=a;Integer b1=b;
  String first=a1.toString();
  String second=b1.toString();
  StringBuffer ans=new StringBuffer("");
  ans.append(first);ans.append(second);
  Integer res=Integer.parseInt(ans.toString());
  return res;
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


    