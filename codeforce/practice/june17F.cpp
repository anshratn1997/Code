/*HEY MY CODE IS BEAUTIFUL AND AWESOME.
*/
#include<bits/stdc++.h>
using namespace std;
#define FOR(i, a, b) for(int i=(a);i<(b);i++)
#define RFOR(i, b, a) for(int i=(b)-1;i>=(a);--i)
#define FILL(A,value) memset(A,value,sizeof(A))
#define ALL(V) V.begin(), V.end()
#define SZ(V) (int)V.size()
#define PB push_back         // for push_back
#define MP make_pair            //for make_pair
#define fr freopen("b.txt","r",stdin);     //for file input
#define fw freopen("a.txt","w",stdout);   //for file output
#define ok printf("ok\n");               //debug
#define pc(x) putchar_unlocked(x);
 
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 1000001;
int len, lpfr[MAX];
int arr[MAX];
int tree[MAX];
int N;
/*
     FOR TAKING INPUT
*/
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
/*
LEAST PRIME FACTOR CALCULATE
    */
void PRIME()
{
    bool prime[MAX+1];
    memset(prime, true, sizeof(prime));
 
    for (int p=2; p<=MAX; p++)
    {
        if (prime[p] == true)
        {
           lpfr[p]=p;
            for (int i=p*2; i<=MAX; i += p){
                if(prime[i]!=false){
                   lpfr[i]=p;}
                   prime[i] = false;}
 
        }
    }
}
/*
FOR COUNSTRUCTING SEGMENT TREE
*/
void cnstr(int nd, int a, int b) {
    if(a > b) return;
 
    if(a == b) {
 
        tree[nd] = arr[a];
        //cout<<nd<<" "<<tree[nd]<<endl;
    return;
  }
 
  cnstr(nd*2, a, (a+b)/2);
    cnstr(nd*2+1, 1+(a+b)/2, b);
 
  tree[nd] = max(lpfr[tree[nd*2]], lpfr[tree[nd*2+1]]);
}
/*
FOR UPDATING TREE
*/
void  update_tr(int nd, int a, int b, int i, int j) {
       //cout<<a<<" "<<b<<" "<<nd<<endl;
  if(a > b || a > j || b < i)
    return;
    if(tree[nd]==1)
        return;
    if(a == b) {
      //      cout<<"keshari="<<a;
        if(a>=i && a<=j)
            tree[nd]=tree[nd]/lpfr[tree[nd]];
       //cout<<"hello"<<tree[nd]<<endl;
        return;
  }
 
  update_tr(nd*2, a, (a+b)/2, i, j);
  update_tr(1+nd*2, 1+(a+b)/2, b, i, j);
 
  tree[nd] = max(lpfr[tree[nd*2]], lpfr[tree[nd*2+1]]);
  //cout<<"vk"<<tree[nd]<<endl;
}
 
/*
FIND MAXIMUM WITHIN RANGE [I.J]
*/
int get(int nd, int a, int b, int i, int j) {
 
  if(a > b || a > j || b < i) return -INF;
  if(tree[nd]==1)
        return 1;
 
    if(a >= i && b <= j)
    {    //cout<<lpfr[tree[nd]]<<" ";
        return lpfr[tree[nd]];}
 
  int q1 = get(nd*2, a, (a+b)/2, i, j);
  int q2 = get(1+nd*2, 1+(a+b)/2, b, i, j);
 
  int res = max(q1, q2);
  //int count=0;
  //count++;
//  printf("%d ",count);
  return res;
 
}
/*
MAIN FUNCCTION START HERE.....
*/
int main()
{
    lpfr[0]=1;
    lpfr[1]=1;
 
    PRIME();
    int t;
   // fr;
 
    t=readInt();
   while(t--)
   {
       int m;
         N=readInt();
         m=readInt();
        FOR(i,0,N)
          arr[i]=readInt();
 
     cnstr(1,0,N-1);
 
 
       int a;
        int l,r;
        FOR(i,0,m)
          {
            a=readInt();
            l=readInt();
            r=readInt();
             if(a==0)
                      update_tr(1,0,N-1,l-1,r-1);
                       //FOR(i,1,4)
                         //cout<<tree[i]<<" ";
                   else
                   {
                       int result=get(1,0,N-1,l-1,r-1);
                       printf("%d ",result);
                    //writeInt(result);
                    //printf(" ");
                   }
         }
        printf("\n");
       }
 
   return 0;
}