import java.io.*;
class A
{
   public static void main(String[] args) throws IOException
   { 
 
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
   	   int t=Integer.parseInt(obj.readLine());
   	   while(t>0){
   	   String st;
   	    st=obj.readLine();
   	    int len=st.length();
   	    int i=0;
   	    int a=0,b=0;
   	    for(i=0;i<len;i++)
   	    {
            if(st.charAt(i)=='0')
          	b++;
            if(st.charAt(i)=='1')
          	a++;
   	    
   	    }
        if(a==1||b==1)
        	System.out.println("Yes");
        else
        	System.out.println("No");
       
            t--;
        }
		
	}
}