import java.io.*;
import java.util.*;
import java.math.*;
public class digits{
    
    
    BufferedReader br;
    
    public static void main(String[] args) {
    new digits().main1();

 
  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
     int n=ii();
     int[] arr=iint();
     ArrayList<Integer> al=new ArrayList<>();
      for (int i=0;i<n ;i++ ) {
         al.add(arr[i]);
       } 
     
     Collections.sort(al);
     HashSet<Integer> set=new HashSet<>();
  
      HashMap<Integer,Integer> map=new HashMap<>();
      for (int i=0;i<n ;i++ ) {
       
        int element=al.get(i);
        
        map.put(element,i);
      }
      ArrayList<ArrayList<Integer>> final_ans=new ArrayList<>();
    for (int i=0;i<n ;i++ ) {
       
        int element=al.get(i);    
        ArrayList<Integer> ans=new ArrayList<>();
        if(arr[i]!=element && !set.contains(i)){
          set.add(i);
           ans.add(i+1);
          int temp_ind=map.get(arr[i]);
          while(!set.contains(temp_ind)){
               set.add(temp_ind);
               ans.add(temp_ind+1);
               int element1=al.get(temp_ind);
               
               if(arr[temp_ind]!=element1)
                 temp_ind=map.get(arr[temp_ind]);

          }

        }
        else if(arr[i]==element){
          ans.add(i+1);
          set.add(i);
        }
        if(ans.size()!=0){
          ans.add(ans.size());
          final_ans.add(ans);
        }
    }
    System.out.println(final_ans.size());
    for (int i=0;i<final_ans.size();i++ ) {
      ArrayList<Integer> temp=final_ans.get(i);
     
         System.out.print(temp.get(temp.size()-1)+" ");
         for (int j=0;j<temp.size()-1 ;j++ ) {
            System.out.print(temp.get(j)+" ");
         }
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
}


    