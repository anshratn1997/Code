#include<bits/stdc++.h>
using namespace std;
int main()
{
    int t;

    cin>>t;
    while(t--)
    {
        unsigned long long int n,b,m;
        cin>>n;
        cin>>b;
        cin>>m;
        unsigned long long int ans=0;
        int count=0;
        while(n>0)
        {
            if(n%2==0)
            {
                ans=ans+b+(n/2)*m;
                n=n/2;
            }
            else
            {
                ans=ans+b+((n+1)/2)*m;
                n=(n-1)/2;
            }
            m=2*m;
            //count++;
        }
        ans=ans-b;
        cout<<ans<<endl;
       // cout<<count<<endl;
    }
    return 0;
}

