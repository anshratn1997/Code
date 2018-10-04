import java.util.*;
import java.io.*;
class C{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int[][] arr=new int[3][3];
		for (int i=0;i<3 ;i++ ) {
			for(int k=0;k<3;k++){
				arr[i][k]=sc.nextInt();
				out.print(arr[i][k]+" ");
			}
			out.println();
		}
      
       out.flush();
       out.close();

	}
}