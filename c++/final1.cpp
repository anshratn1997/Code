#include<bits/stdc++.h>
using namespace std;
//#define for(i, a, b) for(int i=(a);i<(b);i++)
#define rfor(i, b, a) for(int i=(b)-1;i>=(a);--i)
#define mem(a,value) memset(a,value,sizeof(a))
#define allL(v) v.begin(), v.end()
#define sz(v) (int)v.size()
#define pb push_back
#define mp make_pair
#define Pi 3.14159265358979
#define x0 ikjnrmthklmnt
#define y0 lkrjhkltr
#define y1 ewrgrg
#define fr freopen("b.txt","r",stdin);
#define fw freopen("a.txt","w",stdout);
#define ll long long
#define ull unsigned long long
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<x<<" ";
#define ok cout<<"ok"<<endl;
#define vi vector<int>
#define vll vector<ll>
#define  pii pair<int, int>
#define  pll pair<ll, ll>
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
int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int n;
        scanf("%d",&n);
       vector<long long > a(n);
       for(int i=0;i<n;i++)
        scanf("%d",&a[i]);
       sort(a.begin(),a.end());
       int i=0;
       for(i=0;i<n;i++)
       {
           if(a[i]>=0)
            break;
       }
       int index=i,j=0;
       bool ans=false;
       for(j=0;j<index-1;j++)
       {
           int k;
           for(k=0;k<index;k++)
           {
               long long t1=a[j]*a[k];
               if(k!=j){
               if(t1==a[n-1]||(t1==0 || t1==1))
                continue;
               else
                break;
               }

           }
           if(k!=index)
            break;
       }
       //cout(index);
       if(j==index-1 || j==0)
       {  int k;

          for(k=index;k<n-1;k++)
          {
             if((a[k]==0||a[k]==1) )
                continue;
             else
                break;
          }
          if(k==n-1){
            printf("yes\n");
            ans=true;}
          else{
            printf("no\n");
            ans=true;}
       }
       else{
        //ok;
        printf("no\n");}
    }
return 0;
}

