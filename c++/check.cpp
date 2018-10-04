#include <bits/stdc++.h>
using namespace std;
 
typedef long long LL; 
typedef long double LD;
 
const int MAX   = 5e4 + 4;
const int LIM   = 3e5 + 5;
const int MOD   = 1e9 + 7;
const LD  EPS   = 1e-10;
const double PI = acos(-1.0);
 
#define fastio          ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0)
#define Assert(x)       {if(!(x)){cerr<<"Assertion failed at line "<<__LINE__<<": "<<#x<<" = "<<(x)<<"\n";exit(1);}}
#define inchar          getchar_unlocked
#define outchar(x)      putchar_unlocked(x)
 
double tick(){static clock_t oldt,newt=clock();double diff=1.0*(newt-oldt)/CLOCKS_PER_SEC;oldt=newt;return diff;}
template<typename T> void inpos(T &x){x=0;register T c=inchar();while(((c<48)||(c>57))&&(c!='-'))c=inchar();bool neg=0;\
if(c=='-')neg=1;for(;c<48||c>57;c=inchar());for(;c>47&&c<58;c=inchar())x=(x<<3)+(x<<1)+(c&15);if(neg)x=-x;}
template<typename T> void outpos(T n){if(n<0){outchar('-');n*=-1;}char snum[65];int i=0;do{snum[i++]=n%10+'0';n/=10;}\
while(n);i=i-1;while(i>=0)outchar(snum[i--]);outchar(' ');}
inline void instr(char *str){register char c=0;register int i=0;while(c<33)c=inchar();while(c!='\n'&&c!=' '&&c!=EOF){\
str[i]=c;c=inchar();++i;}str[i]='\0';}
template<typename T> T gcd(T a, T b){return(b?__gcd(a,b):a);}
template<typename T> T lcm(T a, T b){return(a*(b/gcd(a,b)));}
int add(int a, int b, int c){int res=a+b;return(res>=c?res-c:res);}
int mod_neg(int a, int b, int c){int res;if(abs(a-b)<c)res=a-b;else res=(a-b)%c;return(res<0?res+c:res);}
int mul(int a, int b, int c){LL res=(LL)a*b;return(res>=c?res%c:res);}
LL mulmod(LL a,LL b, LL m){LL q = (LL)(((LD)a*(LD)b)/(LD)m);LL r=a*b-q*m;if(r>m)r%=m;if(r<0)r+=m;return r;}
template<typename T>T expo(T e, T n){T x=1,p=e;while(n){if(n&1)x=x*p;p=p*p;n>>=1;}return x;}
template<typename T>T power(T e, T n, T m){T x=1,p=e;while(n){if(n&1)x=mul(x,p,m);p=mul(p,p,m);n>>=1;}return x;}
template<typename T>T extended_euclid(T a, T b, T &x, T &y){T xx=0,yy=1;y=0;x=1;while(b){T q=a/b,t=b;b=a%b;a=t;\
t=xx;xx=x-q*xx;x=t;t=yy;yy=y-q*yy;y=t;}return a;}
template<typename T>T mod_inverse(T a, T n){T x,y,z=0;T d=extended_euclid(a,n,x,y);return(d>1?-1:mod_neg(x,z,n));}
 
 
LL ans;
int n, m;
bitset<MAX> mark;
int subtree[MAX];
vector<pair<int,int>> adj[MAX];
 
void dfs(int u, int p) {
    if (mark.test(u)) {
        subtree[u] = 1;
    }
    else {
        subtree[u] = 0;
    }
    for(auto v : adj[u]) {
        if (v.first != p) {
            dfs(v.first, u);
            subtree[u] += subtree[v.first];
            ans += (LL)v.second * ((LL)subtree[v.first] * (m - subtree[v.first]));
        }
    }
}
 
int main() {
    #ifndef ONLINE_JUDGE
        freopen("inp.txt", "r", stdin);
    #endif
    int t, x, y, z;
    inpos(t);
    while(t--) {
        inpos(n), inpos(m);
        for(int i = 1; i < n; ++i) {
            inpos(x), inpos(y), inpos(z);
            adj[x].push_back({y, z});
            adj[y].push_back({x, z});
        }
        for(int i = 1; i <= m; ++i) {
            inpos(x);
            mark.set(x);
        }
        ans = 0;
        dfs(1, 0);
        ans <<= 1;
        LL common = gcd(ans, (LL)m * m);
        outpos(ans/common), outpos((LL)m * m / common);
        outchar('\n');
        for(int i = 1; i <= n; ++i) {
            adj[i].clear();
            mark[i] = 0;
        }
    }
    // cout<<"Execution time : "<<tick()<<"\n";
    return 0;
} 