import java.io.*;
import java.util.*;
import java.math.*;
//public 
class prac12{
    //static variable
    static final int mod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;

    // .......static class
  static class Pair{
      double key,d;
      int value;
      Pair(double key,int value,double d){
        this.key=key;
        this.value=value;
        this.d=d;
      }
      double Key(){
        return key;
      }
      int Value(){
        return value;
      }
      double dis(){
        return d;
      }
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Double key1=o1.Key(),key2=o2.Key();
          return key1.compareTo(key2);
     }
  }
  static class mycomparator1 implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      Double key1=o1.dis(),key2=o2.dis();
          return key1.compareTo(key2);
     }
  }
    
//.............staic class end.
  
    BufferedReader br;
    PrintWriter out;
    public static void main(String[] args) {
    new prac12().main1();
 
  }
  void main1()
  {
    try{
      if (System.getProperty("ONLINE_JUDGE") == null) {
        // Input is a file
        br=new BufferedReader(new FileReader(new File("in.txt")));
        out=new PrintWriter("out.txt");
       } else {
        // Input is System.in
        br=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(System.out);
       }
      
   
      int t=1;
     // t=ii();
      while(t-->0){

        //........solution start

        double[] tel=idouble();
        int n=ii();
        ArrayList<Pair> al=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          double[] tt=idouble();
          double slop=(tt[1]-tel[1])/(tt[0]-tel[0]);
          double d=Math.abs(tt[1]-tel[1])*Math.abs(tt[1]-tel[1])+Math.abs(tt[0]-tel[0])*Math.abs(tt[0]-tel[0]);

          System.out.println(slop);

          if(tt[0]>tel[0])
          al.add(new Pair(slop,(int)tt[2],d));
          else
            al.add(new Pair(-slop,(int)tt[2],d));
        }
        Collections.sort(al,new mycomparator());
        ArrayList<ArrayList<Pair>> set=new ArrayList<>();
       
        ArrayList<Pair> temp=new ArrayList<>();
        Pair pq=al.get(0);

        temp.add(new Pair(pq.Key(),pq.Value(),pq.dis()));
        double first=pq.Key();
        for (int i=1;i<n ;i++ ) {
          Pair p1=al.get(i);
            if(first==p1.Key()){
             temp.add(new Pair(first,p1.Value(),p1.dis()));
            continue;
            }
            
            first=p1.Key();
            set.add(temp);
            temp.clear();
            temp.add(new Pair(first,p1.Value(),p1.dis()));
        }
        if(temp.size()!=0)
          set.add(temp);
       out.println(set.size());
       out.println("helo fuckd fdf");
       long ans=0;
       for (int i=0;i<set.size() ;i++ ) {
         ArrayList<Pair> small=set.get(i);
         Collections.sort(small,new mycomparator1());
         Pair p1=small.get(0);
         int length=p1.Value();
          ans++;
         for (int l=1;l<small.size();l++ ) {
            Pair p2=small.get(l);
            if(length<p2.Value())
            {
              length=p2.Value();
              ans++;
              continue;
            }
            else
              break;
         }

       }
       out.println(ans);
      











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