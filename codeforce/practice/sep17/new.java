import java.io.*;
import java.util.*;
//public 
class A{
	static ArrayList[] graph=null;
	static long bfs(int n){
		Queue<Integer> Q=new LinkedList<>();
		Q.add(1);
		Set<Integer> set1=new HashSet<>();
		Set<Integer> set2=new HashSet<>();
		boolean visited[]=new boolean[n+1];
		Arrays.fill(visited,false);
		long edge=0;
		set1.add(1);
		while(!Q.isEmpty()){
             int u=Q.poll();
             //System.out.println("fdsf"+u);
             visited[u]=true;
             if(set1.contains(u)){
             	for(int i=0;i<graph[u].size();i++)
             	{      int v=(int)graph[u].get(i);
             		   if(!visited[v])
             		   {set2.add(v);edge++;
             		   Q.add(v);}
             		  // System.out.println("dsfd");
             	}
             }
             else{

             	for(int i=0;i<graph[u].size();i++)
             	{      int v=(int)graph[u].get(i);
             		  if(!visited[v])
             		   {set1.add(v);edge++;
             		   Q.add(v);}
             	}
             
             }
		}
		long s1=set1.size();
		long s2=set2.size();
	//	System.out.println(s1);
	//	System.out.println(s2);
	//	System.out.println(edge);
		s1=s1*s2;
		s1=s1-edge;
		return s1;

	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		graph=new ArrayList[n+1];
		for (int i=0;i<=n ;i++ ) {
		  graph[i]=new ArrayList<Integer>();
		}
		for (int i=0;i<n-1 ;i++ ) {
			int x=sc.nextInt(),y=sc.nextInt();
			graph[y].add(x);
			graph[x].add(y);
		}
		System.out.println(bfs(n));
	}

}