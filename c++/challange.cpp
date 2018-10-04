#include<bits/stdc++.h>
#include<stdio.h>
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
#define gc getchar_unlocked
#define mems(arr,a,int) memset(arr,a,sizeof(int));
using namespace std;
typedef long long Int;
typedef unsigned long long UInt;
typedef vector<int> VI;
typedef pair<int, int> PII;
typedef pair<Int, Int> PLL;
typedef pair<double, double> PDD;
typedef complex<double> base;
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 1000001;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;
inline int getchar_unlocked() { return getchar(); }
void scan(int* i)
{
    int t=0;
    char c;
    bool negative=false;
    c=getchar_unlocked();
    while(c<'0'&&c>'9')
    {
        if(c=='-')
            negative=true;
        c=getchar_unlocked();
    }
    while(c>'0'&&c<'9')
    {
        t=(t<<3)+(t<<1)+c-'0';
        c=getchar_unlocked();
    }
    if(negative)
        t=~(t-1); //negative
    *i=t;
}


int main()
{
    int n,m;
    scan(&n);
    scan(&m);
    int a[n+1][n+1];
   FOR(i,0,n)
      FOR(j,0,n)
        scan(&a[i][j]);
    return 0;
}
