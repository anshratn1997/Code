#include<bits/stdc++.h>
#define ok printf("ok\n");
using namespace std;
char visit[1000000001];
char vis[1000000001];
int main()
{

    int n;
    cin>>n;
    vector<int> a(n+1);
    a[0]=0;
    for(int i=1;i<=n;i++)
        cin>>a[i];
        int count=0;
        for(int i=1;i<=n;i++)
        {
          if(visit[a[i]]!='1')
              {
                  count+=(n-i);
                  visit[a[i]]='1';
                  }

        }
        cout<<count<<endl;
        return 0;
}
