import java.io.*;
import java.util.*;
import java.math.*;

 //public 
 class air{
  BufferedReader br;
  //static int[] enc=new int[10];
    public static void main(String[] args) {
    new air().main1();
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     //System.out.println(pow(3,3));
     int n=ii();
     double reddi[]=idouble();
     ArrayList<Map.Entry<Double,Integer> > al=new ArrayList<>();
     for (int i=0;i<n ;i++ ) {
        al.add(new AbstractMap.SimpleEntry(reddi[i],i));
     }
     Collections.sort(al,new Comparator<Map.Entry<Double,Integer>>(){

    @Override
    public int compare(Map.Entry o1, Map.Entry o2){
            Double d1=(Double)o1.getKey();
            Double d2=(Double)o2.getKey();
        return d1.compareTo(d2);
    }
});
    //Map.Entry pq=(Map.Entry)al.get(0);
    //System.out.println(pq.getKey()+" "+pq.getValue());
     double k=di();
     k=(k*1.00)/100.0;
    // double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
     double volume[]=new double[n];
     double total=0.0000;
     for (int i=0;i<n ;i++ ) {

      Map.Entry pq=(Map.Entry)al.get(i);
       Double radius=(Double)pq.getKey();
       double red=(double)radius;
        volume[i]=red*red*red*1.0;
        volume[i] = ((4.000 *3.1400000)/ 3.0) * volume[i];        
        
        int reduce=i+1;
        while(reduce<n){
          volume[i]=volume[i]-(volume[i]*k);
          //volume[i]=(int)(volume[i]*100);
          //volume[i]/=100;
          if(volume[i]<0){
            volume[i]=0.0000;break;
          }
          reduce++;
        }
        
       // System.out.println(volume[i]);
        total+=volume[i];
     }
     total=(int)(total*100.00);
     total=total/100.00;
     System.out.println(total);
    
     

      
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
        a[i]=Double.parseDouble(line[i]);
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