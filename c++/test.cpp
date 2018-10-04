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
pair<int ,int> delet;
int n=0;
int n_max=0;
void min_heapify(vector<pair<int,int> > &a,int i)
{
 int l=2*i;
 int r=2*i+1;
 int largest;
  if(l<n && a[l].first<a[i].second)
     largest=l;
  else
    largest=i;
  if(r<n&& a[r].first<a[largest].first)
     largest=r;
  if(largest!=i)
  {
      pair<int ,int > temp;
      temp.first=a[i].first;
      temp.second=a[i].second;
      a[i].first=a[largest].first;
      a[i].second=a[largest].second;
      a[largest].first=temp.first;
      a[largest].second=temp.second;
      min_heapify(a,largest);
  }
}
void build_minheap(vector<pair<int ,int > > &a)
{
    int i;
    for(i = n/2; i >= 0; i--)
    {
        min_heapify(a,i);
    }
}
void heap_extract(vector<pair<int ,int > > &a)
{
    delet.first=a[0].first;
    delet.second=a[0].second;
    a[0].first=a[n-1].first;
    a[0].second=a[n-1].second;
    n=n-1;
    min_heapify(a,0);
}
void max_heapify(vector<pair<int,int> > &a,int i)
{
 int l=2*i;
 int r=2*i+1;
 int smallest;
  if(l<n_max && a[l].first>a[i].second)
     smallest=l;
  else
    smallest=i;
  if(r<n_max&& a[r].first>a[smallest].first)
     smallest=r;
  if(smallest!=i)
  {
      pair<int ,int > temp;
      temp.first=a[i].first;
      temp.second=a[i].second;
      a[i].first=a[smallest].first;
      a[i].second=a[smallest].second;
      a[smallest].first=temp.first;
      a[smallest].second=temp.second;
      min_heapify(a,smallest);
  }
}
void build_maxheap(vector<pair<int ,int > > &a)
{
    int i;
    for(i = n_max/2; i >= 0; i--)
    {
        max_heapify(a,i);
    }
}
void max_heap_extract(vector<pair<int ,int > > &a)
{
    //cout<<a[0].second<<" ";
    delet.first=a[0].first;
    delet.second=a[0].second;
    a[0].first=a[n_max-1].first;
    a[0].second=a[n_max-1].second;
    n_max=n_max-1;
    max_heapify(a,0);
}

int main()
{
    int n1,k,d;
    cin>>n1;
    cin>>k;
    cin>>d;
    vector<int> a(n1);
    vector<pair<int ,int > > minheap;
     vector<pair<int ,int > > maxheap;
      for(int i=0;i<n1;i++){
         cin>>a[i];
         minheap.push_back(make_pair(abs(a[i]),i+1));
        }
       n=minheap.size();
       build_minheap(minheap);
       cout<<"0 "<<"1"<<endl;
     for(int i=0;i<k;i++)
     {
         heap_extract(minheap);
         cout<<"2 "<<delet.second<<endl;
     }
     /*
     for(int i=0;i<n;i++)
     {
         maxheap.push_back(make_pair(minheap[i].first,minheap[i].second));
        // cout<<minheap[i].second<<" ";
     }
     n_max=n;
     build_maxheap(maxheap);
     for(int i=0;i<d;i++)
     {
        heap_extract(minheap);
        cout<<"1 "<<delet.second<<" ";
        max_heap_extract(maxheap);
        cout<<delet.second<<endl;
     }
     */
     cout<<"-1"<<endl;

return 0;
}
