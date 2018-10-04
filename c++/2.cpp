#include<bits/stdc++.h>
using namespace std;

#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";

#define FOR(i, a, b) for (int i = (a); i <= (b); i++)
#define FORN(i, a, b) for (int i = (a); i < (b); i++)
#define REP(i, n) for (int i = 0; i < (n); i++)
#define FORD(i, a, b) for (int i = (a); i >= (b); i--)
#define BUG(x) cerr << #x << " = " << x << endl
#define SIZE(a) ((int) a.size())

#define oo 2000000000
int main()
{
    int t;
    freopen("b.txt","r",stdin);
    scanf("%d",&t);
    while(t--)
    {

        int n;
        scanf("%d",&n);
        vector<int> a(n);
        int sum=0;
        int mm=100000001;
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
           // sum+=a[i];
           }
            //printf("%d\n",sum);
            //int as=0;
            //int sum1=0;
            //int t1=n-1;
            bool prefix[n+1];
            bool suffix[n+1];
            bool ans=false;
            prefix[0] = prefix[1] = prefix[2] = true;
  for(int i=3;i<=n;i++){
    prefix[i] = (a[i] - a[i - 1] == a[i - 1] - a[i - 2] && prefix[i - 1]);
  }
  suffix[n + 1] = suffix[n] = suffix[n - 1] = true;
  for(int i=n-2;i>=0;i--){
    suffix[i] = (a[i + 1] - a[i + 2] == a[i] - a[i + 1] && suffix[i + 1]);
  }
  cout(suffix[1]);
          int i=0;
         if(n<=3)
         {

               for(int j=0;j<3;j++)
                     mm=min(mm,a[i]);
              printf("%d\n",mm);
         }
         else
         {

             for(i=0;i<n;i++)
             {
                  if(i==0 && suffix[1])
                    {
                        ans=true;
                        cout(mm);
                        cout(i);
                        mm=min(mm,a[i]);
                    }
                else if(i==n-1 && prefix[i-1])
                {
                         cout(mm);
                         cout(i);
                         ans=true;
                         mm=min(mm,a[i]);

                }
                else if(i==1 && suffix[i+1])
                {

                    if(a[0]-a[2]==a[2]-a[3]){
                        ans=true;
                        cout(mm);
                        cout(i);
                        mm=min(mm,a[i]);
                        }
                }
               else if(i==n-2 && prefix[i-1])
                {

                    if(a[n-4]-a[n-3]==a[n-3]-a[n-1]){
                        ans=true;
                        cout(mm);
                        cout(i);
                        mm=min(mm,a[i]);
                        }
                }
                else
                {
                    if(prefix[i-1] && suffix[i+1] && a[i-2]-a[i-1]==a[i-1]-a[i+1] && a[i+1]-a[i+2]==a[i-1]-a[i+1])
                        {
                        ans=true;
                        cout(mm);
                        cout(i);
                        mm=min(mm,a[i]);
                        }

                }

             }
        if(ans){}
          //cout<<mm<<endl;
        else
             printf("-1\n");
         }


    }
    return 0;
}
