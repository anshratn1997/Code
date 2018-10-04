#include<bits/stdc++.h>
using namespace std;
const int MAX=1000001;
bool visited[MAX];
vector<int > adj[MAX];
void bfs(int n,int i)
{
list<int> queue;
 visited[i]=true;
      queue.push_back(i);
      int v;

      while(!queue.empty())
        {
            v=queue.front();
            cout<<v<<" ";
            queue.pop_front();
            vector<int> :: iterator it=adj[v].begin();

      for(;it!=adj[v].end();it++)
      {
          if(!visited[*it])
          {
              queue.push_back(*it);
               visited[*it]=true;
          }
      }
      }

}

int main()
{
    int n;
    scanf("%d",&n);
    memset(visited,false,sizeof(bool));
    for(int i=0;i<n;i++){
        int x,y;
        scanf("%d%d",&x,&y);
        adj[x].push_back(y);
        adj[y].push_back(x);// for undirected;
    }

    bfs(n,0);
    return 0;
}

