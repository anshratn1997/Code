import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
    //static variable
    static final int msod = (int) 1e9 + 7;
    static final double eps = 1e-6;
    static final double pi = Math.PI;
    static final long inf = Long.MAX_VALUE / 2;

    // .......static class
   static class Pair{
      String key;
      int value;
      Pair(String key,int value){
        this.key=key;
        this.value=value;
      }
      String Key(){
        return key;
      }
      int Value(){
        return value;
      }
  }
  static class mycomparator implements Comparator<Pair>{
     @Override
    public int compare(Pair o1,Pair o2){
      String key1=o1.Key(),key2=o2.Key();
          return key1.compareTo(key2);
     }
  }
   static class mycomparator1 implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      String key1=o1.Key(),key2=o2.Key();
          return key2.compareTo(key1);
     }
  }
  static class mycomparator2 implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){

      String s1=o1.Key(),s2=o2.Key();
      String sb1=trim_s(s1);
      String sb2=trim_s(s2);
   
      int l1=sb1.length(),l2=sb2.length();
     if(l1==l2)
      {
              for (int i=0;i<l1 ;i++ ) {
                  int a=sb1.charAt(i)-48;
                  int b=sb2.charAt(i)-48;
                  if(a==b)
                    continue;
                  if(a<b){
                   
                    return -1;
                  }
                  else{
                    
                    return 1;
                  }
              }
              return 0;

      }
      else if(l1<l2)
        return -1;
      else
        return 1;
      
     
     }
  }
  static class mycomparator21 implements Comparator<Pair>{
     @Override
     public int compare(Pair o1,Pair o2){
      String s1=o1.Key(),s2=o2.Key();
      String sb1=trim_s(s1);
      String sb2=trim_s(s2);

      int l1=sb1.length(),l2=sb2.length();

     if(l1==l2)
      {
              for (int i=0;i<l1 ;i++ ) {
                  int a=sb1.charAt(i)-48;
                  int b=sb2.charAt(i)-48;
                  if(a==b)
                    continue;
                  if(a<b)
                    return 1;
                  else
                    return -1;
              }
              return 0;

      }
      else if(l1<l2)
        return 1;
      else
        return -1;
      
     
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
     // t=ii();
      while(t-->0){

        //........solution start
        int n=ii();
        ArrayList<String> al=new ArrayList<>();
        for (int i=0;i<n ;i++ ) {
          al.add(si());

        }
        String last=si();
        String line[]=last.split(" ");
        int key=Integer.parseInt(line[0]);
        String rev=line[1];
        String type=line[2];
       
        if(type.equals("numeric")){
          
          ArrayList<Pair> num=new ArrayList<>();
          for (int i=0;i<n ;i++ ) {
             String str=al.get(i);
             String ll[]=str.split(" ");
     
            num.add(new Pair(ll[key-1],i));
          }
          
          Collections.sort(num,new mycomparator2());
          if(rev.equals("true"))
            for (int i=n-1;i>=0 ;i-- ) {
                Pair p=num.get(i);
            System.out.println(al.get(p.Value()));
            }
          else
          for (int i=0;i<n ;i++ ) {
            Pair p=num.get(i);
            System.out.println(al.get(p.Value()));
          }

        }
        else{

          ArrayList<Pair> num=new ArrayList<>();
          for (int i=0;i<n ;i++ ) {
             String str=al.get(i);
             String ll[]=str.split(" ");
     
            num.add(new Pair(ll[key-1],i));
          }
         
          Collections.sort(num,new mycomparator());
          if(rev.equals("true")) 
          for (int i=n-1;i>=0 ;i-- ) {
            Pair p=num.get(i);
            System.out.println(al.get(p.Value()));
          }
          else
            for (int i=0;i<n ;i++ ) {
               Pair p=num.get(i);
              System.out.println(al.get(p.Value()));
            }


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

  static String trim_s(String s){
    int i=0;
    for (i=0;i<s.length() ;i++ ) {
        if(s.charAt(i)=='0')
          continue;

        break;
    }
    int l=s.length();
    return s.substring(i,l);
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