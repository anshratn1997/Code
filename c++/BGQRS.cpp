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
const int MAX = 1000001;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;
int len, sp[MAX];
int arr[MAX];
int tree[MAX];
int N;
int readInt () {
	bool minus = false;
	int result = 0;
	char ch;
	ch = getchar_unlocked();
	while (true) {
		if (ch == '-') break;
		if (ch >= '0' && ch <= '9') break;
		ch = getchar();
	}
	if (ch == '-') minus = true; else result = ch-'0';
	while (true) {
		ch = getchar();
		if (ch < '0' || ch > '9') break;
		result = result*10 + (ch - '0');
	}
	if (minus)
		return -result;
	else
		return result;
}
inline void writeInt (int n)
    {
        int N = n, rev, count = 0;
        rev = N;
        if (N == 0) { pc('0'); pc('\n'); return ;}
        while ((rev % 10) == 0) { count++; rev /= 10;}
        rev = 0;
        while (N != 0) { rev = (rev<<3) + (rev<<1) + N % 10; N /= 10;}
        while (rev != 0) { pc(rev % 10 + '0'); rev /= 10;}
        while (count--) pc('0');
    }
void cnstr(int nd, int a, int b) {
    if(a > b) return;

  	if(a == b) {
    		tree[nd] = arr[a];
		return;
	}

	cnstr(nd*2, a, (a+b)/2);
    cnstr(nd*2+1, 1+(a+b)/2, b);

	int temp=tree[nd*2];
	int count_5=0;
	while(temp>0)
    {
        temp=temp/5;
        count_5++;
    }
    tree[nd]+=count_5;
    count_5=0;
    temp=tree[nd*2+1];
    while(temp>0)
    {
        temp=temp/5;
        count_5++;
    }
    tree[nd]+=count_5;
}
void  update_tr(int nd, int a, int b, int i, int j) {

	if(a > b || a > j || b < i)
		return;
    if(tree[nd]==1)
        return;

  	if(a == b) {
        tree[nd]=tree[nd]/sp[tree[nd]];
    		return;
	}

	update_tr(nd*2, a, (a+b)/2, i, j);
	update_tr(1+nd*2, 1+(a+b)/2, b, i, j);
	int temp=tree[nd*2];
	int count_5=0;
	while(temp>0)
    {
        temp=temp/5;
        count_5++;
    }
    tree[nd]+=count_5;
    count_5=0;
    temp=tree[nd*2+1];
    while(temp>0)
    {
        temp=temp/5;
        count_5++;
    }
    tree[nd]+=count_5;
}


int get(int nd, int a, int b, int i, int j) {

	if(a > b || a > j || b < i) return -INF;

		if(a >= i && b <= j)
		{    //cout<<sp[tree[nd]]<<" ";
		    return tree[nd];}

	int q1 = get(nd*2, a, (a+b)/2, i, j);
	int q2 = get(1+nd*2, 1+(a+b)/2, b, i, j);

	int res = q1+q2;
	return res;
}
