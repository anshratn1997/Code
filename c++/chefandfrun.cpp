#include<bits/stdc++.h>
using namespace std;
const int MAX=1000001;
bool visited[MAX];
//vector<int> path;
vector<int > adj[MAX];
int set_ab[max];
void dfs(int v)
{
     // visited[v]=true;
      // cout<<v<<" ";
     vector<int>:: iterator i=adj[v].begin();
      for(;i!=adj[v].end();i++){
        if(set_ab[*it]==set_ab[v])

       if(set_ab[*it]==0)
       {
           if(set_ab[v]==1)
             set_ab[*it]=2
            else
            set_ab[*it]=1;
           dfs(*it);
       }
      }
}
int main()
{
     int t;
     scanf("%d",&t);
     while(t--)
     {
         int n,m;
         scanf("%d%d",&n,&m);
         for(int i=0;i<n;i++)
             for(int j=0;j<n;j++)
                if(i!=j)
                    adj[i].push_back(j);
         for(int i=0;i<m;i++)
         {
             int x,y;
            scanf("%d%d",&x,&y);
            adj[x].erase(std::remove(adj[x].begin(),adj[x].end(), y), adj[x].end());
         }


     }
    return 0;
}
