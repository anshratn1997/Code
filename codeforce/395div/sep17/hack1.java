import java.io.*;
import java.util.*;
import java.math.*;
//public 
class A{
	//static Scanner sc=null;
	static BufferedReader br=null;
	static PrintWriter out=null;
	static List graph[]=null;
    static int[] color=null;
	static LinkedList[] s_color=null;
	static int[] ans=null;
	static boolean visit[]=null;

	void dfs(int u,int k){
		visit[u]=true;
		
		int sz=s_color[color[u]].size();
		if(sz<k)
			ans[u]=-1;
		else{
		
			ans[u]=(int)s_color[color[u]].get(sz-k);	
		}
		s_color[color[u]].add(u);
		
		for(int i=0;i<graph[u].size();i++){
			int v=(int )graph[u].get(i);
			if(!visit[v]){
				dfs(v,k);
			}
		}
		s_color[color[u]].poll();

	}
	void main1() throws IOException
	{
      
      String tt=br.readLine();
      String tt1[]=tt.split(" ");
       int n=Integer.parseInt(tt1[0]),k=Integer.parseInt(tt1[1]);
       graph=new List[n+1];
       ans=new int[n+1];
       visit=new boolean[n+1];
       Arrays.fill(visit,false);

       for (int i=0;i<=n ;i++ ) {
       	 graph[i]=new ArrayList<Integer>();
       }
       color=new int[n+1];
       int max=-1;
       color[0]=0;
       String tt2=br.readLine();
       String tt3[]=tt2.split(" ");
       for (int i=1;i<=n ;i++ ) {
       	 color[i]=Integer.parseInt(tt3[i-1]);
       	 if(max<color[i])
       	 	max=color[i];
       }
       s_color=new LinkedList[max+1];
       for(int i=0;i<=max;i++)
       	s_color[i]=new LinkedList<Integer>();
       for (int i=1;i<n ;i++ ) {
       	String tt4=br.readLine();
       	String tt5[]=tt4.split(" ");
       	 int x=Integer.parseInt(tt5[0]),y=Integer.parseInt(tt5[1]);
       	 graph[x].add(y);graph[y].add(x);
       }
             dfs(1,k);
             for (int i=1;i<=n ;i++ ) {
             	out.print(ans[i]+" ");
             	
             }
		out.flush();
		out.close();
	}
	public static void main(String[] args) throws IOException{
	//FileReader fr=new FileReader("input.in");
	//out=new PrintWriter("out.txt");
	//sc=new Scanner(fr);
    //sc=new Scanner(System.in);
	br=new BufferedReader(new InputStreamReader(System.in))
	out=new PrintWriter(System.out);
	
        new A().main1();
		
		

	}
}