#include<bits/stdc++.h>
using namespace std;
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 1000001;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;
#define pc putchar();
#define gc getchar();
int N;
int arr[MAX];
int tree[MAX];
int readInt () {
	bool minus = false;
	int result = 0;
	char ch;
	ch = getchar();
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
void cnstr(int nd, int a, int b) {
    if(a > b) return;

  	if(a == b) {

    		tree[nd] = arr[a];
        //cout<<nd<<" "<<tree[nd]<<endl;
		return;
	}

	cnstr(nd*2, a, (a+b)/2);
    cnstr(nd*2+1, 1+(a+b)/2, b);

	tree[nd] = tree[nd*2]+tree[nd*2+1];
}
void  update_tr(int nd, int a, int b, int i, int j) {

	if(a > b || a > j || b < i)
		return;
    //if(tree[nd]==0)
      //   return;
      tree[nd]=tree[nd]+1;
    if(a!=b){
	update_tr(nd*2, a, (a+b)/2, i, j);
	update_tr(1+nd*2, 1+(a+b)/2, b, i, j);}
	//tree[nd]=tree[2*nd]+tree[2*nd+1];
}


int get(int nd, int a, int b, int i, int j) {

	if(a > b || a > j || b < i) return 0;

		if(a >= i && b <= j)
		{    //cout<<tree[nd]<<" ";
		    return tree[nd];}

	int res=0;
	res=get(nd*2, a, (a+b)/2, i, j)+get(1+nd*2, 1+(a+b)/2, b, i, j);
//cout<<res;
	return res;

}

int main()
{
    int N,q;
   // freopen("b.txt","r",stdin);
    N=readInt();
    q=readInt();
    for(int i=0;i<=N;i++)
       arr[i]=0;
      cnstr(1,0,N-1);
    for(int i=0;i<q; i++ )
    {
        int t,l,r;
        //scanf("%d%d%d",&t,&l,&r);
        t=readInt();
        l=readInt();
        r=readInt();
        if(t==1)
            update_tr(1,0,N-1,l-1,r-1);
        else if(t==2)
        {
            int res=get(1,0,N-1,l-1,r-1);
               printf("%d\n",res);

        }
    }
    return 0;
}
