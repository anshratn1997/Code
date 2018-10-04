#include<bits/stdc++.h>
#define ok printf("ok\n");
using namespace std;
int visit[10001];
int main()
{
    int n;
    cin>>n;
    vector<int> a(n+1);
    a[0]=0;
    for(int i=1;i<=n;i++)
        cin>>a[i];
    int s,e;
    cin>>s;
    cin>>e;
    int i=0,t=0;
    while(visit[i]!=1)
    {
ok;
        s=a[i];
        i=a[i];
        visit[i]=1;
        if(s==e){

            ok;break;}
        t++;
    }
    cout<<i;
    if(s==e)
        cout<<"Yes"<<endl;
    else
    cout<<"No"<<endl;

    return 0;
}
