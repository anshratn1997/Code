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
void PRIME()
{
    bool prime[MAX+1];
    memset(prime, true, sizeof(prime));

    for (int p=2; p<=MAX; p++)
    {
        if (prime[p] == true)
        {
           sp[p]=p;
            for (int i=p*2; i<=MAX; i += p){
                if(prime[i]!=false){
                   sp[i]=p;}
                   prime[i] = false;}

        }
    }
}

void cnstr(int nd, int a, int b) {
    if(a > b) return;

  	if(a == b) {

    		tree[nd] = arr[a];
        //cout<<nd<<" "<<tree[nd]<<endl;
		return;
	}

	cnstr(nd*2, a, (a+b)/2);
    cnstr(nd*2+1, 1+(a+b)/2, b);

	tree[nd] = max(sp[tree[nd*2]], sp[tree[nd*2+1]]);
}
void  update_tr(int nd, int a, int b, int i, int j) {

	if(a > b || a > j || b < i)
		return;
    if(tree[nd]==1)
        return;

  	if(a == b) {
        tree[nd]=tree[nd]/sp[tree[nd]];
      // cout<<tree[nd]<<" ";
    		return;
	}

	update_tr(nd*2, a, (a+b)/2, i, j);
	update_tr(1+nd*2, 1+(a+b)/2, b, i, j);

	tree[nd] = max(sp[tree[nd*2]], sp[tree[nd*2+1]]);
}


int get(int nd, int a, int b, int i, int j) {

	if(a > b || a > j || b < i) return -INF;

		if(a >= i && b <= j)
		{    //cout<<sp[tree[nd]]<<" ";
		    return sp[tree[nd]];}

	int q1 = get(nd*2, a, (a+b)/2, i, j);
	int q2 = get(1+nd*2, 1+(a+b)/2, b, i, j);

	int res = max(q1, q2);
	//int count=0;
	//count++;
//	printf("%d ",count);
	return res;

}

int main()
{
    sp[0]=1;
    sp[1]=1;
    PRIME();
    int t;
    fr;
    t=readInt();
   while(t--)
   {
       int m;
         N=readInt();
         m=readInt();
        FOR(i,0,N)
          arr[i]=readInt();

     cnstr(1,0,N-1);
    // FOR(i,1,N-)
      //   cout<<tree[i]<<" ";

       int a;
        int l,r;
        FOR(i,0,m)
          {
            a=readInt();
             l=readInt();
             r=readInt();
              if(a==0)
                      update_tr(1,0,N-1,l-1,r-1);
               else
                {
                       int result=get(1,0,N-1,l-1,r-1);
                      // printf("%d ",result);
                   writeInt(result);
                    printf(" ");
                }
         }
        printf("\n");
       }

   return 0;
}

