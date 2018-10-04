import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
 BufferedReader br;
 

    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     long temp[]=ilong();
     long arr[]=ilong();
     ArrayList<Long> pos=new ArrayList<>();
     for (long i=0;i<temp[0] ;i++ ) {
        if(arr[(int)i]==1)
          pos.add(i);
     }
     long min=Long.MAX_VALUE;
      long tt=pos.get(0);
     if(pos.size()<temp[1])
      System.out.println("-1");
    else{
       long[] distance=new long[pos.size()];
       long[] bin=new long[pos.size()];
       distance[0]=0;
       bin[0]=0;
      for(int i=1;i<pos.size();i++)
      {
        distance[i]=(pos.get(i)-pos.get(i-1));
      }
      for(int i=1;i<pos.size();i++)
      {
        bin[i]=(pos.get(i)-pos.get(i-1))*temp[2];
      }
      for(int i=1;i<pos.size();i++)
      {
        bin[i]=bin[i-1]+bin[i];
      }
      int i=1;
      for(i=1;i<(int)temp[1];i++)
       {
            tt=tt+(i*distance[i]*temp[2]);
       }
       min=tt;
       for(i=(int)temp[1];i<pos.size();i++){
        tt=tt+pos.get(i-(int)temp[1]+1)-pos.get(i-(int)temp[1]);
        tt=tt-(bin[i-1]-bin[i-(int)temp[1]]);                     
        tt=tt+(distance[i]*(temp[1]-1)*temp[2]);
        min=Math.min(min,tt);                  
                                      
       }
       System.out.println(Math.min(min,tt));
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