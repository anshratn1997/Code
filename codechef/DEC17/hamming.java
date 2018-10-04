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
      int key,value;
      Pair(int key,int value){
        this.key=key;
        this.value=value;
      }
      int Key(){
        return key;
      }
      int Value(){
        return value;
      }
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

        //........solution start
        int n=ii();
        int[] a=iint();
        boolean[] v=new boolean[n];
        Arrays.fill(v,false);
        int[][] ind=new int[100001][2];
        int[] b=new int[n];
        int[] fre=new int[100001];
        ArrayList<Integer> one=new ArrayList<>();
        ArrayList<Integer> db=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
           fre[a[i]]++;
           if(fre[a[i]]==1)
             ind[a[i]][0]=i+1;
           else{
            ind[a[i]][1]=i+1;
  
          }
          
        }
        for(int i=0;i<100001;i++){
          if(fre[i]==2)
            db.add(i);
          if(fre[i]==1)
            one.add(i);
        }
        for (int i=0;i<=db.size()-2;i+=2 ) {
          int first=db.get(i),sec=db.get(i+1);
          b[ind[first][0]-1]=sec;v[ind[first][0]-1]=true;
          b[ind[first][1]-1]=sec;v[ind[first][1]-1]=true;
          b[ind[sec][0]-1]=first;v[ind[sec][0]-1]=true;
          b[ind[sec][1]-1]=first;v[ind[sec][1]-1]=true;
        }

        int ff=0;
        if(db.size()%2!=0 && db.size()!=0)
        {
          // System.out.println("fuck");
          if(one.size()>=2)
          {  ff=2;
             int first=one.get(0),sec=one.get(1);
             int sz=db.size();
             b[ind[db.get(sz-1)][0]-1]=first;v[ind[db.get(sz-1)][0]-1]=true;
             b[ind[db.get(sz-1)][1]-1]=sec;v[ind[db.get(sz-1)][1]-1]=true;
             b[ind[first][0]-1]=db.get(sz-1);v[ind[first][0]-1]=true;
             b[ind[sec][0]-1]=db.get(sz-1);v[ind[sec][0]-1]=true;
          }
          else if(one.size()==1){
            int first=one.get(0);
            int sz=db.size();
             b[ind[db.get(sz-1)][0]-1]=first;v[ind[db.get(sz-1)][0]-1]=true;
             b[ind[first][0]-1]=db.get(sz-1);v[ind[first][0]-1]=true;
          }
        }
        for (int i=ff+1;i<one.size() ;i++ ) {
          // System.out.println("mc");
           int first=one.get(i-1),sec=one.get(i);
           b[ind[first][0]-1]=sec;v[ind[first][0]-1]=true;
        }
        if(one.size()!=0){
           int last=one.get(one.size()-1);
           if(!v[ind[last][0]-1]){
         
               b[ind[last][0]-1]=one.get(ff);
               if(b[ind[last][0]-1]!=a[ind[last][0]-1])
                v[ind[last][0]-1]=true;
             }

        }
        int hm=0,f=0;
        int[] loc={-1,-1};
        for (int i=0;i<n ;i++ ) {
           if(!v[i]){
             b[i]=a[i];loc[f]=i;f++;
           }
           else
            hm++;
        }
        if(hm<n)
        {
          boolean done=false;
          int fk=0;
          for (int i=0;i<n ;i++ ) {
             if(i==loc[0]|| i==loc[1])
              continue;
             if(a[i]!=b[loc[fk]] && a[loc[fk]]!=b[i])
             {
                int temp=b[i];
                b[i]=b[loc[fk]];
                b[loc[fk]]=temp;
                fk++;

                if(fk==f){
                  done=true;break;
                }
             }
          }
          if(done)
          {
              System.out.println(n);
              for (int i=0;i<n ;i++ ) {
                System.out.print(b[i]+" ");
              }
              System.out.println();
              continue;
          }
          else{

              System.out.println(hm);
              for (int i=0;i<n ;i++ ) {
                System.out.print(b[i]+" ");
              }
              System.out.println();
              continue;
          }
        }
        System.out.println(hm);
        for (int i=0;i<n ;i++ ) {
          System.out.print(b[i]+" ");
        }
        System.out.println();


  
        









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