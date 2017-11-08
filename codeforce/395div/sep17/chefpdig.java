import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    

  
    BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      int t=1;
      t=ii();
      while(t-->0){
       String inp=si();
       int[] d=new int[10];
       Arrays.fill(d,0);
      for(int i=0;i<inp.length();i++){
           int ch=inp.charAt(i)-48;
           d[ch]++;
       }
       //StringBuffer sb=new StringBuffer("");
       List<Character> sb=new ArrayList<>();
       for(int i=6;i<10;i++)
       { if(d[i]!=0){
             if(i==6){
               for(int k=5;k<10 ;k++ ) {
                   if(i!=k && d[k]!=0){int num=i*10+k;sb.add((char)num);}
                   else if(i==k && d[k]>=2){int num=i*10+i;sb.add((char)num);}
                  }
               }
              else if(i==9){
                if(d[0]!=0){
                int num=i*10;sb.add((char)num);}
              }
              else{//System.out.println("fsdk "+i);
                for (int k=0;k<10 ;k++ ) {
                    if(i!=k && d[k]!=0){int num=i*10+k;sb.add((char)num);}
                    else if(i==k && d[k]>=2){int num=i*10+i;sb.add((char)num);}
              }}
          }
        }
        //char ch[]=sb.toString().toCharArray();
        //Arrays.sort(ch);
        Collections.sort(sb);
        for(int i=0;i<sb.size();i++)
          System.out.print(sb.get(i));
        if(sb.size()==0)
          System.out.println();
        System.out.println();
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
    String[] isa(int n) throws IOException{
        String at =si();
        return at.split(" ");
    }

    double[][] idm(int n, int m) throws IOException{
        double a[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
          double[] temp=idouble();
          for (int j = 0; j < m; j++) a[i][j] = temp[j];
        }
        return a;
    }

    int[][] iim(int n, int m) throws IOException{
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
          int[] temp=iint();
          for (int j = 0; j < m; j++) a[i][j] =temp[j];
        }
        return a;
    }
    long[][] ilm(int n, int m) throws IOException{
       long a[][] = new long[n][m];
        for (int i = 0; i < n; i++) {
          long[] temp=ilong();
          for (int j = 0; j < m; j++) a[i][j] =temp[j];
        }
        return a;
    }
    
} 