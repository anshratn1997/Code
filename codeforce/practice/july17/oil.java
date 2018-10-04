import java.io.*;
import java.util.*;
import java.math.*;
//public 
class oil{
    
    
    BufferedReader br;
    static int[][] field=new int[11][11];
    public static void main(String[] args) {
    new oil().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     String line=si();
     String sep[]=line.split(",");
     int m=Integer.parseInt(sep[0]),n=Integer.parseInt(sep[1]);
     
     for(int i=0;i<m;i++){
       String row=si();
       String element[]=row.split(",");
       for(int j=0;j<n;j++){
         field[i][j]=Integer.parseInt(element[j]);
       }
     }
     String cor=si();
     String pos[]=cor.split(",");
     int px=Integer.parseInt(pos[0]),py=Integer.parseInt(pos[1]);
     System.out.println(1+findpath(px-1,py-1,m,n));
    

     
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }
  int findpath(int x,int y,int m,int n){
     if(x>=m||y>=n||x<0||y<0){
     // System.out.println(x+" "+y);
      return 0;}
      //System.out.println("hello call me");
     Stack<Integer> st1=new Stack<>();
     Stack<Integer> st2=new Stack<>();
     int max1=-999;
     if(x+1<m && y<n){
      //System.out.println("1 st");
      //System.out.println("cor "+(x+1)+" "+y);
      //System.out.println("ok1"+field[x][y]+" "+field[x+1][y]);
      if(field[x+1][y]<field[x][y]){
      max1=field[x+1][y];
      st1.push(x+1);
      st2.push(y);
      //System.out.println("ok2");
       }
      }
     //System.out.println("first "+max1);
     if(x<m && y+1<n){
      //System.out.println("2 nd");
      if(field[x][y+1]<field[x][y]){
      if(field[x][y+1]==max1)
      { 
        st1.push(x);
        st2.push(y+1);

      }
      else if(field[x][y+1]>max1){
        while(!st1.empty()){
        st1.pop();
        st2.pop();}
        st1.push(x);
        st2.push(y+1);
        max1=field[x][y+1];
          
      }
     }}
     //System.out.println("second "+max1);
     if(x-1>=0 && y<n){
      //System.out.println("3rd");
      if(field[x-1][y]<field[x][y]){
        if(field[x-1][y]==max1)
      { 
        st1.push(x-1);
        st2.push(y);

      }
      else if(field[x-1][y]>max1){
        while(!st1.empty()){st1.pop();st2.pop();}
        st1.push(x-1);
        st2.push(y);
        max1=field[x-1][y];
          
      }

      }
     }
     //System.out.println("third "+max1);
     if(x<m && y-1>=0){
      if(field[x][y-1]<field[x][y]){
        if(field[x][y-1]==max1)
      { 
        st1.push(x);
        st2.push(y-1);

      }
      else if(field[x][y-1]>max1){
        while(!st1.empty()){st1.pop();st2.pop();}
        st1.push(x);
        st2.push(y-1);
        max1=field[x][y-1];
          
      }

      }
     }
     
     int max2=0;
     while(!st1.empty()){
         // System.out.println("sz "+st1.size());
          int xx=(int)st1.peek();
          st1.pop();
          int yy=(int)st2.peek();
          st2.pop();
        max2=Math.max(max2,1+findpath(xx,yy,m,n));
     }
     return max2;
    
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


    