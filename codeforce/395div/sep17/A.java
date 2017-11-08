import java.io.*;
import java.util.*;
import java.math.*;
public class A{
	static Scanner sc=null;
	static boolean ans=true;
	static PrintWriter out=null;
	 void kickstart(ArrayList<Integer> al){
       if(al.size()>1){
       	int l=0,r=al.size()-1;
       	 int mid=(l+r)/2;
       	 int key=al.get(mid);
       	 int lf=0,rt=0;
       	  ArrayList<Integer> aa=new ArrayList<>();
       	  ArrayList<Integer> bb=new ArrayList<>();
       	 for(int i=l;i<=r;i++){
       	 	if(al.get(i)<=key && i!=mid)
       	 		aa.add(al.get(i));
       	 	else if(i!=mid)
       	 		bb.add(al.get(i));}

       	 if(aa.size()==bb.size())
       	 	ans=false;
       	 else{
       	 	kickstart(aa);
       	 	kickstart(bb);
       	 }

       }
	}
	void main1() throws IOException
	{
       
         int t=sc.nextInt();
		int j=0;
		while(t-->0){
			j++;
		    int n=sc.nextInt();
		    ArrayList<Integer> al=new ArrayList<>();
		    for(int i=0;i<n;i++)
		    	al.add(sc.nextInt());
		    kickstart(al);
			 if(ans)
             out.println("Case #"+j+": "+"YES");
             else
            out.println("Case #"+j+": "+"NO");
         ans=true;

		}
		out.flush();
		out.close();
	}
	public static void main(String[] args) throws IOException{
	FileReader fr=new FileReader("input.in");
	out=new PrintWriter("out.txt");
		sc=new Scanner(fr);
    //sc=new Scanner(System.in);
	//out=new PrintWriter(System.out);
	
        new A().main1();
		
		

	}
}