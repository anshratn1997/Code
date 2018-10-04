#include<bits/stdc++.h>
using namespace std;
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int n,m,c;
        scanf("%d%d%d",&n,&m,&c);
        vector<int> a;
        for(int i=1;i<=c;i++)
        {
            if(c%i==0)
                a.push_back(i);
        }
        int j=a.size()-1;
        int i=0,ans=0;

        for(i=0;i<=j;i++)
        {
            for(int k=0;k<=j;k++)
            {
                if(a[i]*a[k]==c ) {
                if(a[i]<=n && a[k]<=m)
                    ans++;
                }
            }
        }

       cout<<ans<<endl;
    }
    return 0;
}
