
import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;

//public 
class Main{
static class CustomComparator implements Comparator <Long[] >
{
    @Override
    public int compare(Long[] o1,Long[] o2) {       
        return o1[1].compareTo(o2[1]);
          }  
}
static class CustomComparator1 implements Comparator <Pair<Pair<Long,Long>,Integer>>
{
    @Override
    public int compare(Pair<Pair<Long,Long>,Integer> o3,Pair<Pair<Long,Long>,Integer> o4) {       
        return o4.getKey().getValue().compareTo(o3.getKey().getValue());
          }  
}

  

 BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      long t=li();
      while(t-->0){
      long nd[]=ilong();
      long n=nd[0],d=nd[1];
      Long details[][]=new Long[(int)n+1][4];
      long sum=0;
      details[0][1]=0L;details[0][2]=0L;details[0][3]=0L;
      for (int i=1;i<=n ;i++ ) {
            long tempp[]=ilong();
            details[i][1]=tempp[0];
            details[i][2]=tempp[1];
            details[i][3]=tempp[2];
            sum+=tempp[1]*tempp[2];
         }
      Arrays.sort(details ,new CustomComparator());
      PriorityQueue<Pair<Pair<Long,Long>,Integer> > pq=new PriorityQueue<>(new CustomComparator1());
      long sad=0;
      int j=1;
      while(details[j][1]==1){
         pq.add(new Pair(new Pair(1L,details[j][3]),j));
         j++;
         if(j==n+1)
          break;
      }
      if(!pq.isEmpty()){
      Pair temp=pq.peek();
      
      Pair tt=(Pair)temp.getKey();
      sad=sad+(long)tt.getValue();
      details[(int)temp.getValue()][2]-=1;
      if(details[(int)temp.getValue()][2]==0)
         pq.poll();}
      //System.out.println(sad);
       //System.out.println(details[3][1]);
      for(int i=2;i<=(int)d;i++) {
        //System.out.println("hello");
        if(j<=(int)n){
         while(details[j][1]<=i){
          pq.add(new Pair(new Pair(i,details[j][3]),j));
          j++;
          if(j==n+1)
            break;
          //Pair temp11=pq.peek();
          //Pair tt11=(Pair)temp11.getKey();
          //System.out.println(tt11.getValue()+"ff");
          //System.out.println(details[j][1]+" "+j);
         }
           }

        if(!pq.isEmpty()){
         Pair temp1=pq.peek();
         
         Pair tt1=(Pair)temp1.getKey();
         sad=sad+(long)tt1.getValue();
         //System.out.println(tt1.getValue()+"ff");
         details[(int)temp1.getValue()][2]-=1;
         if(details[(int)temp1.getValue()][2]==0)
            pq.poll();
        }
          //System.out.println(i);

      }
      System.out.println(sum-sad);
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
    

}