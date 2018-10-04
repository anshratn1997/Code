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

    // .......static class
 static class Pair{
      int key,min,max,time;
      String israted,color;
      Pair(int key,int min,int max,int time,String israted,String color){
        this.key=key;
        this.min=min;
        this.israted=israted;
        this.color=color;
        this.max=max;
        this.time=time;
      }
      int Key(){
        return key;
      }
      int Max(){
        return max;
      }
      int Min()
      {
        return min;

      }
      int TIme(){return time;}
      String Israted(){return israted;}
      String Color(){return color;}
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Integer key1=o1.Key(),key2=o2.Key();
          return key1.compareTo(key2);
     }
  }
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new Main().main1();
 
  }
  void main1()
  {
    try{
       
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
      int t=1;
     t=ii();
      while(t-->0){

        //.
        // .......solution start
        int n=ii();
      ArrayList<Pair> al=new ArrayList<>();
      for (int i=0;i<n ;i++ ) {
         String st=si();
         String li[]=st.split(" ");
al.add(new Pair(Integer.parseInt(li[0]),Integer.parseInt(li[1]),Integer.parseInt(li[2]),Integer.parseInt(li[3]),li[4],li[5]));
      }
      boolean visit[]=new boolean[n];
      Arrays.fill(visit,false);
      for (int i=0;i<n ;i++ ) {
           Pair ai=al.get(i);
           int loc=-1;

           for (int j=0;j<i;j++ ) {
              Pair aj=al.get(j);
              boolean time=aj.TIme()==ai.TIme()?true:false;
              boolean mini=aj.Key()>=ai.Min() && aj.Key()<=ai.Max()?true:false;
              boolean maxi=ai.Key()>=aj.Min() && ai.Key()<=aj.Max()?true:false;
              boolean rate=aj.Israted().equals(ai.Israted());
              boolean colr=false;
              if((aj.Color().equals("black") && ai.Color().equals("white")) || (aj.Color().equals("white") && ai.Color().equals("black")))
                {colr=true;}

              if(aj.Color().equals("random") && ai.Color().equals("random"))
                colr=true;
              if(mini && maxi && rate && colr && time)
                 {
                  if(!visit[j]){
                    loc=j;
                    visit[j]=true;
                    visit[i]=true;
                    break;
                  }
                  
                } 

           }
           if(loc==-1)
             System.out.println("wait");
           else
            System.out.println(loc+1);
      }
  
        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.




  //................end.
  
  
   //..............input method start. 
    int getmax(int a[]){
      int n=a.length;
      int max=a[0];
      for (int i=1;i<n ;i++ ) {
        max=Math.max(a[i],max);
      }
      return max;
    }
     int getmin(int a[]){
      int n=a.length;
      int min=a[0];
      for (int i=1;i<n ;i++ ) {
        min=Math.min(a[i],min);
      }
      return min;
    }

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
    //..............input methods end;
    
} 