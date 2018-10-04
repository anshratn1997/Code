#include <bits/stdc++.h>
using namespace std;
 
const int N = 1e5;
int n, a[N], Pow[20];
 
int main(int argc, char **argv) {
    Pow[0] = 1;
    for (int i = 1; i < 20; ++i)
        Pow[i] = Pow[i - 1] << 1;
    int t;
    scanf("%d", &t);
    while (t-- != 0) {
        scanf("%d", &n);
        for (int i = 0; i < n; ++i)
            scanf("%d", &a[i]);
        long long res = 0;
        int freq[20] = { };
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < 3; ++j) {
                if (((a[i] >> j) & 1) == 0)
                    freq[j] = 0;
                else
                    ++freq[j];
                cout<<freq[j]<<" ";
                res += (long long) freq[j] * Pow[j];
                //printf("%lld\t", res);
            }
            cout<<endl;
        } printf("%lld\n", res); 
    }
    return 0;
}