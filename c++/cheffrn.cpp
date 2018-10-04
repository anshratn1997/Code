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
#define inf 0x7fffffff;
#define pc(x) putchar_unlocked(x);
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
bool adlist[MAX][MAX];
int main()
{

  ios::sync_with_stdio(0);
  memset(adjlist,1,sizeof(bool));
  int t;
  cin>>t;
while(t--)
  {
       memset(adlist,1,sizeof(bool));
       int n,m;
       cin>>n;
       cin>>m;
       int x,y;
       FOR(i,0,m)
      {
        cin>>x;
        cin>>y;
        adlist[x][y]=true;
        adlist[y][x]=true;
      }


    }
 return 0;
}
