import java.io.*;
import java.util.*;
import java.math.*;

 public class Main{
	static long mod1=1000000007L;
	static long mod2=1000000009L;
 
 BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      int temp[]=iint();
      int n=temp[0],k=temp[1];
      String inp=si();
      int[] start=new int[27];
      int[] end=new int[27];
      Arrays.fill(start,-1);
      Arrays.fill(end,-1);
      for(int i=0;i<inp.length();i++){
          if(start[inp.charAt(i)-65]==-1){
            start[inp.charAt(i)-65]=i;
            //System.out.println(end[inp.charAt(i)-65]);
          }
      }
      for(int i=inp.length()-1;i>=0;i--){
          if(end[inp.charAt(i)-65]==-1){
            end[inp.charAt(i)-65]=i;
          }
      }
    
      Queue<Integer> guards_av=new LinkedList<>();
      Queue<Integer> guards_busy=new LinkedList<>();
      for (int i=1;i<=k ;i++ ) {
        guards_av.add(i);
      }
   
     boolean ans=true;
      for (int i=0;i<n;i++ ) {
           if(start[inp.charAt(i)-65]==i){
             if(!guards_av.isEmpty()){
             int temp1=guards_av.poll();
             guards_busy.add(temp1);}
             else{
              ans=false;
              break;
             }
             
           }
           if(end[inp.charAt(i)-65]==i)
           {
              if(!guards_busy.isEmpty()){
             int temp1=guards_busy.poll();
             guards_av.add(temp1);}
             
           }

      }
      if(ans)
        System.out.println("NO");
      else
        System.out.println("YES");
    
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