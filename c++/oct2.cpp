#include<bits/stdc++.h>
using namespace std;
int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        long long a,v;
        scanf("%lld%lld",&a,&v);
        double ans;
        ans=(2*a*1.0)/(3*v);
        printf("%lf\n",ans);
    }
    return 0;
}
