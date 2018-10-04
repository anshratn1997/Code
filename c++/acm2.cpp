#include<bits/stdc++.h>
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
using namespace std;
int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        string s;
        cin>>s;
        int l=s.size();
        long long int sum=0;
        for(int i=0;i<l;i++)
        {
            if(s[i]>=48 && s[i]<=57)
                sum=sum+(s[i]-48);
        }
        cout<<sum<<endl;
    }
    return 0;
}
