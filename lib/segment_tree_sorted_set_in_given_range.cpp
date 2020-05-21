#include <bits/stdc++.h>

using namespace std;

const int MaxN = 2e5 + 10;
const int INF = 1e9;

int n, q, a[MaxN];
multiset < int > t[4 * MaxN];

int foo(const multiset < int > &s, int x) {
	multiset < int > :: iterator it = s.upper_bound(x);
	
	int res = -1;
	if (it != s.end()) {
		res = max(res, *it);
	}

	return res;
}

int get(int v, int L, int R, int l, int r, int val) {
	if (L == l && r == R) {
		return foo(t[v], val);
	}
	int M = (L + R) / 2;
	if (r <= M) {
		return get(v + v, L, M, l, r, val);
	}
	if (l > M) {
		return get(v + v + 1, M + 1, R, l, r, val);
	}
	int lft=get(v + v, L, M, l, M, val);
     int rgt=get(v + v + 1, M + 1, R, M + 1, r, val);
    if(lft!=-1 && rgt!=-1)
    	return min(lft,rgt);
    else
    	return max(lft,rgt);
}

void upd(int v, int l, int r, int pos, int oval, int val) {
	int m = (l + r) / 2;
	assert (t[v].find(oval) != t[v].end());
	t[v].erase(t[v].find(oval));
	t[v].insert(val);
	if (l != r) {
		if (pos <= m) {
			upd(v + v, l, m, pos, oval, val);
		} else {
			upd(v + v + 1, m + 1, r, pos, oval, val);
		}
	}
}

void build(int v, int l, int r) {
	if (l != r) {
		int m = (l + r) / 2;
		build(v + v, l, m);
		build(v + v + 1, m + 1, r);
		multiset < int > :: iterator it = t[v + v].begin();
		multiset < int > :: iterator jt = t[v + v + 1].begin();
		while (it != t[v + v].end() && jt != t[v + v + 1].end()) {
			if (*it < *jt) {
				t[v].insert(t[v].end(), *it++);
			} else {
				t[v].insert(t[v].end(), *jt++);
			}
		}
		while (it != t[v + v].end()) {
			t[v].insert(t[v].end(), *it++);
		}
		while (jt != t[v + v + 1].end()) {
			t[v].insert(t[v].end(), *jt++);
		}
	} else {
		t[v].insert(a[l]);
	}
}

void destroy(int v, int l, int r) {
	t[v].clear();
	if (l != r) {
		int m = (l + r) / 2;
		destroy(v + v, l, m);
		destroy(v + v + 1, m + 1, r);
	}
}

int main() {
//	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
	int t=1;
	assert (1 <= t && t <= 1000);
	while (t --> 0) {
		scanf("%d", &n);
		for (int i = 1; i <= n; ++i) {
			scanf("%d", &a[i]);
		}
		build(1, 1, n);
		scanf("%d",&q);
		for (int i = 1; i <= q; ++i) {
			int ty, x, y,p;
			scanf("%d",&ty);
			if (ty == 1) {
				scanf("%d%d",&x,&y);
				upd(1, 1, n, x, a[x], y);
				a[x]=y;
			} else {
                 scanf("%d%d%d",&x,&y,&p);
				long long val= get(1, 1, n, x, y,p);
				printf("%lld\n",val);
			}
		}
		destroy(1, 1, n);
	}
	return 0;
}