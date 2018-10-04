import java.io.*;
import java.util.*;
import java.math.*;
//public 
class A{
	static Scanner sc=null;
   	static int[] a=null;
     static ArrayList<ArrayList<Integer> > al=new ArrayList<>();
     static ArrayList<Integer> end=new ArrayList<>();
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
     void main1(){
       int n=sc.nextInt();
       a=new int[n];
       for(int i=0;i<n;i++)
        	a[i]=sc.nextInt();
        ArrayList<Integer> child=new ArrayList<>();
        /*
        child.add(10);
        child.add(8);
        child.add(6);
        child.add(4);
        child.add(2);
        child.add(-1);*/
        //System.out.println(BinaryS(child,5));
        child.add(a[0]);
        al.add(child);
        end.add(a[0]);
        for(int i=1;i<n;i++){
         int ind=BinaryS(end,a[i]);
         if(ind>=end.size()){
         	end.add(a[i]);
         	ArrayList<Integer> child1=new ArrayList<>();
         	child1.add(a[i]);
         	al.add(child1);
         }
         else{
         	al.get(ind).add(a[i]);
         	end.set(ind,a[i]);
         }
        }
        for(ArrayList tt:al){
        	for(int i=0;i<tt.size();i++)
        		System.out.print(tt.get(i)+" ");
          System.out.println();
        }

     }
	public static void main(String[] args) throws IOException{
		sc=new Scanner(System.in);
        new A().main1();
	}
}