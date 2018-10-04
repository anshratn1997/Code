import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;
/*///public 
class  Main{
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     int k=Integer.parseInt(br.readLine());
     ArrayList<Integer> al=new ArrayList<>();
     
     int t=n-1,j=0;
     while(t>0){
          al.add(t);
          j++;
          t=al.get(j-1)-2;
      }
     for (int i=1;i<al.size() ;i++ ) {
          al.set(i,al.get(i)+al.get(i-1));
      }
      //System.out.println(binarysearch(al,13));
       char[] ch=new char[n+1];
      if(k>(n/2)*(n-n/2))
        System.out.println("");
      else{
       
        int ind=binarysearch(al,k);
        if(ind<0)
            ch[n-k]='A';
        else{
            for(int i=0;i<=ind;i++)
                 ch[i+1]='A';
            if(k-al.get(ind)>0)
                ch[n-(k-al.get(ind))]='A';
       }
      }
      for (int i=1;i<=n ;i++ ) {
          if(ch[i]!='A')
            System.out.print("B");
           else
            System.out.print("A");
      }
   }
  catch(Exception e){}

  }
  int binarysearch(ArrayList<Integer> al,int key)
  {
    int lo=0,hi=al.size()-1;
    int mid=0;
    while(lo<=hi){
         mid=(lo+hi)>>1;
        if(al.get(mid)==key)
            return mid;
        else if(al.get(mid)<key)
             lo=mid+1;
         else 
             hi=mid-1;
    }
    return hi;

  }
}
*/
class AB{
    public String createString(int N,int K){
    ArrayList<Integer> al=new ArrayList<>();
     int t=N-1,j=0;
     while(t>0){
          al.add(t);
          j++;
          t=al.get(j-1)-2;
      }
     for (int i=1;i<al.size() ;i++ ) {
          al.set(i,al.get(i)+al.get(i-1));
      }
      //System.out.println(binarysearch(al,13));
       char[] ch=new char[N];
      if(K>(N/2)*(N-N/2))
        System.out.println("");
      else{
       
        int ind=binarysearch(al,K);
        if(ind<0)
            ch[N-K-1]='A';
        else{
            for(int i=0;i<=ind;i++)
                 ch[i]='A';
            if(K-al.get(ind)>0){
                int diff=K-al.get(ind);
                ch[N-ind-2-diff]='A';
            }
       }
      }
      for (int i=0;i<N ;i++ ) 
          if(ch[i]!='A')
             ch[i]='B';
      String res=new String(ch);
      return res;
  }
  public int binarysearch(ArrayList<Integer> al,int key)
  {
    int lo=0,hi=al.size()-1;
    int mid=0;
    while(lo<=hi){
         mid=(lo+hi)>>1;
        if(al.get(mid)==key)
            return mid;
        else if(al.get(mid)<key)
             lo=mid+1;
         else 
             hi=mid-1;
    }
    return hi;

  }
    
}
class Main{
    public static void main(String[] args) {
        AB obj=new AB();
        System.out.println(obj.createString(7,7));

    }
}