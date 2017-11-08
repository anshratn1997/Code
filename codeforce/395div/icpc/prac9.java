import java.io.*;
import java.util.*;
import java.math.*;
//public 
class edu11{
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
    new edu11().main1();
 
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
        String line=si();
        String ll[]=line.split(" ");
        char[] dic={'A','H','I','M','O','T','U','V','W','X','Y'};
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<11;i++){
           map1.put(dic[i],i+1);
        }
        long k=Integer.parseInt(ll[0]);
        String g=ll[1];
        long n=g.length();
        long ind=0;
        long count=0;
        while(n>0){
              n--;
           Character ch=g.charAt((int)n);
           ind=ind+map1.get(ch)*(long)Math.pow(11,count);
           count++;
        }
        //System.out.println("after convert "+ind);
        ind=ind+k;
        long temp=ind;
        int len=0;
        if(ind%11==0){

        }
       
        while(temp>0){
           len++;
           temp/=11;

        }
        
        //System.out.println("len of String "+len);
        StringBuffer sb=new StringBuffer("");
        for (int i=len-1;i>=0 ;i-- ) {
          long fuck=(long)Math.pow(11,i);
          long index=ind/fuck;
          ind=ind-fuck*index;
          sb.append(dic[(int)index-1]);
        }
        System.out.println(sb.toString());

       


        









        //..........solution end.

     }
     out.flush();
     out.close(); 
    }
    catch(Exception e){
        e.printStackTrace();}    
  }


  // ...............required method.
  public  int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    int BinaryS(ArrayList<Integer> temp,int key){
        int l=0,r=temp.size()-1;
        int mid=0;
        while(l<=r){
           mid=(l+r)/2;
          // System.out.println(mid);
          if(key>temp.get(mid))
            r=mid-1;
          else
            l=mid+1;
        }
          //System.out.println(l+" "+r);

        return (l+r+1)/2;

    }
  StringBuffer lele(long num){
     
  }




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