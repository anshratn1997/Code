#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n,m;
    scanf("%d%d",&n,&m);
    bool visited[m+1];
    for(int i=0;i<=m;i++)
        visited[i]=false;
    vector<int > a(n);
    for(int i=0;i<n;i++)
        scanf("%d",&a[i]);
    sort(a.rbegin(),a.rend());
     //for(int j=1;j<=m;j++)
       // cout<<visited[j]<<" ";
    for(int i=0;i<n;i++)
    {
        for(int j=m;j>=1;j--)
        {
            if(!visited[j] && a[i]%j==0)
            {
              visited[j]=true;
               //cout<<j<<endl;
              break;
            }

        }
    }
    int ans=0;
    for(int j=1;j<=m;j++){
       // cout<<visited[j]<<" ";
        if(visited[j]){
         ans++;
        }
    }
    cout<<ans<<endl;
    return 0;
}
