
import java.io.*;
import java.util.*;
import java.math.*;
//public 
class Main{
  
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int arr[]=iline(br);
       int m=arr[0];
       int b=arr[1];
       int my=b;
       int mx=m*b;
       long sum=my;
       long x=0L;
       long y=b;
       long locx=0L,locy=0L;
       if(mx>=my){
       	if(mx==1 && my==1)
       	{
       	   locy=0;
       	   locx=0;
       	}
        else{
       	 if(my%2!=0){
        
       	locy=my/2;
       	locx=(locy+1)*m;}
       	else
       	{
       	    locy=my/2;
       	    locx=(locy)*m;	
       	}
       }
   }
       
      // System.out.println(locx+" "+locy);
       //System.out.println(max);
       long ans=(locy+1)*((locx)*(locx+1))/2+(locx+1)*((locy)*(locy+1))/2;
       System.out.println(ans);


     }
    catch(Exception e){
        e.printStackTrace();}

  }
  int[] iline(BufferedReader br)
  {
  	String line[]=br.readLine().split(" ");
  	int arr[]=new int[line.length];
  	for (int i=0;i<line.length;i++ ) {
  		 arr[i]=Integer.parseInt(line[i]);
  	}
  	return arr;
  }
  
}