#include <bits/stdc++.h>
using namespace std;
const int MAX=1000001;
bool visited[MAX];
vector<int> path;
vector<int > adj[MAX];
void dfs(int n,int v)
{
      visited[v]=true;
      //cout<<v<<" ";
      vector<int>:: iterator i=adj[v].begin();
      for(;i!=adj[v].end();i++){
       if(visited[*i]==false)
             dfs(n,*i);
      }
}
int count(int n,int v){
    int c=0;
 for(int i=1;i<=n;i++)
    visited[i]=false;
    dfs(n,v);
    for (int i=1; i <=n; ++i)
    {
        //cout<<"heflkdfo ";
        if(visited[i]==false){
            c++;
            dfs(n,i);
           // cout<<i<<" ";
        }
    }
    return c;
}
int main(){

    int *p=0;
    cout<<"dsd";
    *p=true;
    cout<<*p;
    int n;
    cin >> n;
    int m;
    cin >> m;
    int s;
    cin >> s;
    memset(visited,false,sizeof(bool));
    for (int i=0; i<m; ++i)
    {
            int x,y;
            cin>>x;cin>>y;
            adj[x].push_back(y);
            adj[y].push_back(x);
    }
    int q;
    cin >> q;
    int s1;
    cin >> s1;
    for (int i = 0; i < q; ++i)
    {
        //cout<<"helo ";
       int x,y;
       cin>>x;cin>>y;
       adj[x].push_back(y);
       adj[y].push_back(x);
       int res=count(n,x);
       cout<<res<<" ";
       //cout<<"helo 1 ";


    }

}