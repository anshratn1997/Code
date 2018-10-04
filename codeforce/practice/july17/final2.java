import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Spiral{
    
    static int max=1000001;
    
    static boolean prime[]=new boolean[max];
    ArrayList<Integer> primelist=new ArrayList<>();
   
    BufferedReader br;
    public static void main(String[] args) {
    new Spiral().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     int t=ii();
     while(t-->0){
      PRIME();
       //System.out.println(primelist.get(0));
        int n=ii();
        int loop=0;
        int yinc=-1;
        int xinc=0,index=0,posx=0,posy=0;
        boolean find=false;
        while(index<78498){
          yinc+=2;
          xinc+=1;
         // System.out.println(xinc+" ok1 "+yinc);
          for(int i=0;i<=xinc;i++){
              index++;
              if(primelist.get(index-1)==n)
              {//System.out.println("ok1"+index);
                posx=i;
                posy=-loop;
                find=true;
                break;
              }
          }
          if(find)
            break;    
          for(int i=-loop+1;i<=yinc-loop;i++){
             index++;
             if(primelist.get(index-1)==n)
             {
              //System.out.println("ok2 "+index);

              posx=loop+1;posy=i;
             // System.out.println(posx+" "+posy);
              find=true;
              break;
             }
          }
          if(find)
            break;
          for (int i=loop;i>=-xinc ;i-- ) {
             index++;
             if(primelist.get(index-1)==n)
             {
              ///System.out.println("ok3 "+index);
              posx=i;posy=yinc-loop;
              find=true;
              break;
             }
          }
          if(find)
            break;
          for (int i=yinc-loop-1;i>=-(loop+1) ;i-- ) {
             index++;
             
             if(primelist.get(index-1)==n)
             {
              //System.out.println("ok4 "+index);
              posx=-xinc;posy=i;
              find=true;
              break;
             }
          }
            if(find)
              break;
          for (int i=-xinc+1;i<0 ;i++ ) {
                index++;
                if(primelist.get(index-1)==n){
                 // System.out.println("ok 5 "+index);
                  posx=i;posy=-(loop+1);
                  find=true;
                  break;
                }
              }
          if(find)
            break;    
          loop++;
        }
        System.out.println(posx+" "+posy);
     }
    
 
    
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
     int count=0;
     for (int i=2;i<max ;i++ ) {
        if(prime[(int)i]){
           primelist.add(i);
           count++;
           
           }
     }
     //System.out.println(count);
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


    