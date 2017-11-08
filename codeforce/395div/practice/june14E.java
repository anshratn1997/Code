#include<bits/stdc++.h>
using namespace std;
#define fi first
#define se second
#define pb push_back
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define bye return 0;
typedef long long int LL;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<pii> vpi;
typedef vector<vi> vvi;
void si(int &n){scanf("%d", &n);}
void sii(int &n, int &m){scanf("%d%d", &n, &m);}
#define forn(i, n) for (int i = 0; i < (int)(n); ++i)
#define for1(i, n) for (int i = 1; i <= (int)(n); ++i)
#define DEBUG(X) { cerr << #X << " = " << (X) << endl; }
constexpr LL TEN(int n) { return (n==0) ? 1 : 10*TEN(n-1); }
template<class T> bool uin(T &a, T b) { return a > b ? (a = b, true) : false; }
template<class T> bool uax(T &a, T b) { return a < b ? (a = b, true) : false; }
const int N = 1e5 + 5;
const int M = 1e6 + 6;
const LL MOD = 1e9 + 7;
// upper_bound(all(v), x) - v.begin(); // number of elements <=x.
int n, q, fact[M], a[N];
vpi tree[4 * N];
 
void primeFact() {
    int lim = M;
    int sq = sqrt(lim) + 1;     
    for (int i = 2; i <= lim; i++) {
        if (!fact[i]) {         
            fact[i] = i;
            if (i > sq) continue;
            for (int j = i*i; j <= lim; j += i) fact[j] = i;
        }
    }
}
 
void dec(vpi &to, int x){       
    map<int, int> mp;
    while(fact[x]){
        mp[fact[x]]++;
        x /= fact[x];
    }
    to.pb({0, 0});
    for(auto x : mp){
        to.pb({x.fi, x.se});
    }
}
void merge(int id){
    vpi& to = tree[id];
    vpi& from1 = tree[2 * id];
    vpi& from2 = tree[2 * id + 1];
    vpi::iterator it1 = from1.begin(), it2 = from2.begin();
    
    while( (it1 != from1.end()) && (it2 != from2.end()) ){
        if(it1->fi == it2->fi){
            to.pb({it1->fi, it1->se + it2->se});
            it1++, it2++;
            continue;
        }
        if(it1->fi < it2->fi){
            to.pb({it1->fi, it1->se});
            it1++;
            continue;
        }
        to.pb({it2->fi, it2->se});
        it2++;          
    }
    if(it1 != from1.end()) while(it1 != from1.end()){to.pb({it1->fi, it1->se}); it1++;}
    if(it2 != from2.end()) while(it2 != from2.end()){to.pb({it2->fi, it2->se}); it2++;}
}
void build(int id = 1, int l = 0, int r = n - 1){
    
    if(l == r){
        dec(tree[id], a[l]);  // decompose a[l] and store in tree[id]
        return;
    }
    int mid = (l + r) / 2;
    build(2 * id, l, mid);
    build(2 * id + 1, mid + 1, r);
    merge(id);
}
bool cmp(pii a, pii b){
    return a.fi < b.fi;
}
 
int L, R, X, Y;
 
int query(int id = 1, int l = 0 , int r = n - 1){
    if(l>R || r<L)return 0;
    if(l >= L && r <= R){
        int lo, hi, ans;
        hi = upper_bound(all(tree[id]), make_pair(Y, 0), cmp) - tree[id].begin();
        lo = upper_bound(all(tree[id]), make_pair(X - 1, 0), cmp) - tree[id].begin();
        ans = tree[id][hi - 1].se - tree[id][lo - 1].se;    
        return ans;
    }
 
    int mid = (l + r)/2;
    return query(2 * id, l, mid) + query(2 * id + 1, mid + 1, r);
}
 
void prefixSum(int id, int l, int r){
    if(l == r){
        for(int i = 1; i < tree[id].size(); i++){
            tree[id][i].se += tree[id][i - 1].se; 
        }
        return;
    }
    int mid = (l + r) / 2;
    prefixSum(2 * id, l, mid);
    prefixSum(2 * id + 1, mid + 1, r);
    
    for(int i = 1; i < tree[id].size(); i++){
        tree[id][i].se += tree[id][i - 1].se; 
    }
} 
 
int main(){
// ios::sync_with_stdio(false);
 
primeFact();
si(n); forn(i, n){ si(a[i]); }
 
build(1, 0, n - 1);
prefixSum(1, 0, n - 1);
 
si(q);
forn(i, q){
    scanf("%d%d%d%d", &L, &R, &X, &Y);  
    L--, R--;
    printf("%d\n", query());
}
 
}   