#include<bits/stdc++.h>
using namespace std;
const int MAX=1000001;
bool visited[MAX];
vector<int> path;
vector<int > adj[MAX];
void dfs(int n,int v)
{
      visited[v]=true;
      cout<<v<<" ";
      vector<int>:: iterator i=adj[v].begin();
      for(;i!=adj[v].end();i++){
       if(visited[*i]==false)
             dfs(n,*i);
      }
}
bool iscyclic_check(int n,int v,int parent)
{
     visited[v]=true;
     vector<int > :: iterator it=adj[v].begin();
     for(;it!=adj[v].end();it++)
     {
         if(!visited[*it])
             iscyclic_check(n,*it,v);
         else
            if(*it!=parent)
             return false;
     }
     return  true;
}
bool iscyclic(int n,int v)
{
    vector<int > ::iterator it=adj[v].begin();
    for(;it!=adj[v].end();it++){
        if(!visited[*it])
             if(iscyclic_check(n,*it,-1))
                 return true;}

    return false;
}
void printallpath(int s,int d)
{
      visited[s]=true;
      path.push_back(s);
      if(s==d)
      {
          for(int i=0;i<path.size();i++)
             cout<<path[i]<<" ";
          cout<<endl;
      }
      else{
      vector<int> ::iterator it=adj[s].begin();
      for(;it!=adj[s].end();it++)
      {
          if(!visited[*it])
              printallpath(*it,d);
      }
      }
      visited[s]=false;
      path.pop_back();
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
    }
    //dfs(n,0);
    //if(iscyclic(n,0))
      // cout<<"cycle";
    printallpath(0,3);
    return 0;
}
