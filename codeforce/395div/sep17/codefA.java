import java.io.*;
import java.util.*;
import java.math.*;
public 
class codefA{
  static class Pair{
      int key,value;
      Pair(int key,int value){
        this.key=key;
        this.value=value;
      }
      int getKey(){
        return key;
      }
      int getValue(){
        return value;
      }
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Integer key1=o1.getKey(),key2=o2.getKey();
          return key1.compareTo(key2);
     }
  }
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;
    static int ass[]=null;
    static int max=-1;
    ArrayList<Pair> arr=null;
    
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new codefA().main1();
 
  }
  
  void main1()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     out=new PrintWriter(System.out);
      int t=1;
      t=ii();
      while(t-->0){
        
         //.................while loop start.
        

        int n=ii();
        int[] a=iint();
         arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
          arr.add(new Pair(a[i],i));
        }
        Collections.sort(arr,new mycomparator());
        
       
        Pair last=arr.get(n-1);
        int ans[]=new int[n+1];
        for (int i=0;i<n ;i++ ) {
           Pair p=arr.get(i);

           if(i!=n-1){
             ans[p.getValue()]=(p.getKey()+last.getKey())%mod;
            // System.out.println("fdsjf");
           }
           else{
          ans[p.getValue()]=(arr.get(i-1).getKey()+p.getKey())%mod;}
          int up_bd=Binary(mod-1-p.getKey());
         // System.out.println("index : "+up_bd);
          //System.out.println("ans: "+ans[p.getValue()]);
          if(up_bd>=0){
              if(up_bd!=i)
              ans[p.getValue()]=Math.max((p.getKey()+arr.get(up_bd).getKey())%mod,ans[p.getValue()]);
              else if(up_bd-1>=0)
                ans[p.getValue()]=Math.max((p.getKey()+arr.get(up_bd-1).getKey())%mod,ans[p.getValue()]);

          }
          //System.out.println("ans: "+ans[p.getValue()]);

        }
        for (int i=0;i<n;i++) {
          out.print(ans[i]+" ");
        }
        out.println();
        




        














        // ..............while loop end
       

      }
      out.flush();
      out.close();
  }
    catch(Exception e){
        e.printStackTrace();}
    
  }

  //............required method to solve
  int Binary(int key){
   
    int l=0,r=arr.size()-1;
    int mid=0;
      while(r-l>1){
        mid=l+(r-l)/2;
        Pair p=arr.get(mid);
        if(key>=p.getKey())
          l=mid;
        else
          r=mid;
      }
      //System.out.println("l r "+l+" "+r);
      return l;
  }



  //...........end of methods

  
   //input method
    int[] iint() throws IOException{
      String line[]=br.readLine().split(" ");
      int[] a=new int[line.length];
      for (int i=0;i<line.length ;i++ ) {
        a[i]=Integer.parseInt(line[i]);
        max=Math.max(a[i],max);
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