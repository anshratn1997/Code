import java.io.*;
import java.util.*;
import java.math.*;
import javafx.util.Pair;

//public 
class Main{
 BufferedReader br;
    public static void main(String[] args) {
    new Main().main1();

  }
  void main1 ()
  {
    try{
     br=new BufferedReader(new InputStreamReader(System.in));
      long t=li();
      while(t-->0){
      	String str=si();
      	int n1=0;
      	boolean cont=true;
      	int max1=0;
      	for (int i=0;i<str.length() ;i++ ) {
      		if(str.charAt(i)=='>' && cont){
      			n1++;
      			max1=Math.max(max1,n1);
      		}
      		else if(str.charAt(i)=='=' && cont){
      			continue;
      		}
      		else if(str.charAt(i)=='>' && !cont){
      			n1=1;
      			cont=true;
      			max1=Math.max(max1,n1);
      		}
      		else{
      			cont=false;
      		}	
      	}
      	//System.out.println(n1);
      	int n2=0,max2=0;
      	cont=true;
      	for (int i=0;i<str.length() ;i++ ) {
      		if(str.charAt(i)=='<' && cont){
      			n2++;
      			max2=Math.max(max2,n2);
      		}
      		else if(str.charAt(i)=='=' && cont)
      			continue;
      		else if(str.charAt(i)=='<' && !cont){
      			n2=1;
      			cont=true;
      			max2=Math.max(max2,n2);
      		}
      		else{
      			cont=false;
      		}	
      	}
      	//System.out.println(n2);
      	System.out.println(Math.max(max1,max2)+1);
        
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