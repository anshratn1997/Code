
// C++ program to print DFS traversal from a given vertex in a  given graph
#include<bits/stdc++.h>
using namespace std;
const int MAX = 1000001;
int arr[MAX];
bool *visited=new visited;

// Graph class represents a directed graph using adjacency list representation
class Graph
{
    int V;    // No. of vertices
    list<int> *adj;    // Pointer to an array containing adjacency lists
    void DFSUtil(int v, bool visited[]);  // A function used by DFS
   public:
    Graph(int V);   // Constructor
    void addEdge(int v, int w);   // function to add an edge to graph
    void DFS(int v);    // DFS traversal of the vertices reachable from v
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w); // Add w to v’s list.
}

void Graph::DFSUtil(int v, bool visited[])
{
    // Mark the current node as visited and print it
    visited[v] = true;
    cout << v << " ";

    // Recur for all the vertices adjacent to this vertex
    list<int>::iterator i;
    for (i = adj[v].begin(); i != adj[v].end(); ++i)
        if (!visited[*i])
            DFSUtil(*i, visited);
}

// DFS traversal of the vertices reachable from v. It uses recursive DFSUtil()
void Graph::DFS(int v)
{
    // Mark all the vertices as not visited

    for (int i = 0; i < V; i++)
     //   visited[i] = false;

    // Call the recursive helper function to print DFS traversal
    DFSUtil(v, visited);
}

int main()
{
    int t;
    scanf("%d",&t);
    while(t--){
    int n;
    scanf("%d",&n);
            for(int i=0;i<n;i++)
                scanf("%d",&arr[i]);
    Graph g(n);
    *visited=new visited[n];
    memset(visited,false,sizeof(bool));
    for(int i=0;i<n;i++){

         g.addEdge(i,i+1);

    }
    g.addEdge(n,0);
    for(int i=0;i<n;i++)
   {
       g.DFS(i);
   }
    }

    return 0;
}
