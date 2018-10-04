#include<bits/stdc++.h>
using namespace std;
#define FOR(i, a, b) for(int i=(a);i<(b);i++)
#define RFOR(i, b, a) for(int i=(b)-1;i>=(a);--i)
#define FILL(A,value) memset(A,value,sizeof(A))
#define ALL(V) V.begin(), V.end()
#define SZ(V) (int)V.size()
#define PB push_back
#define MP make_pair
#define Pi 3.14159265358979
#define x0 ikjnrmthklmnt
#define y0 lkrjhkltr
#define y1 ewrgrg
#define fr freopen("b.txt","r",stdin);
#define fw freopen("a.txt","w",stdout);
#define ok printf("ok\n");
typedef long long Int;
typedef unsigned long long UInt;
typedef vector<int> VI;
typedef pair<int, int> PII;
typedef pair<Int, Int> PLL;
typedef pair<double, double> PDD;
typedef complex<double> base;
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 1000000;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;
int different_cookies(int *arr)
{
    int c=0;
    FOR(i,1,7)
    {
        if(arr[i]!=0)
            c++;
    }
   // cout<<c<<endl;
    return c;
}
void reduce(int *arr)
{
    FOR(i,1,7)
    {
        if(arr[i]!=0)
            arr[i]--;
    }
}
int chef(int *dict,int ans)
{
  int diff=different_cookies(dict);
  if(diff<=3){
      return ans;}
  else
  {
      if(diff==4)
        ans+=1;
      else if(diff==5)
        ans+=2;
      else
        ans+=4;
    reduce(dict);
   return chef(dict,ans);
  }
}
int main()
{
    int t;
    //fr;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        vector<pair<int,int> > point;
        FOR(i,1,n+1)
        {
            int n_cookies;
            cin>>n_cookies;
            int dict[]={0,0,0,0,0,0,0};
          FOR(i,1,n_cookies+1)
           {
               int temp;
               cin>>temp;
               dict[temp]+=1;
           }
            int ans=chef(dict,n_cookies);
            point.PB(make_pair(ans,i));
           // cout<<ans<<endl;

        }
       sort(point.rbegin(),point.rend());

        if(point[0].first==point[1].first)
          printf("tie\n");
        else if(point[0].second==1)
            printf("chef\n");
       else
          cout<<point[0].second<<endl;
    }
    return 0;
}
