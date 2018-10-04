#include <bits/stdc++.h>
using namespace std;
int m[1000001];
int arr[1000001];
void update(int pos,int val, int n, vector<int>&tree)
{
  tree[pos]+=val;
  while((pos+(pos&(-pos)))<=n)
  {
    pos+=(pos&(-pos));
    tree[pos]+=val;
  }
}
 
long long query(int idx, vector<int>&tree)
{
  long long ans=tree[idx];
  while((idx&(idx-1))>0)
  {
    idx=(idx&(idx-1));
    ans+=tree[idx];
  }
  return ans;
}
int main()
{
  ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int t=1;
    cin>>t;
	while(t-->0){
	int n;
  cin>>n;
	
	std::vector<int> a(n);
  vector<int>tree(1000001,0);
	int aa[n];
	for (int i = 0; i < n; ++i)
	{
		/* code */
    // scanf("%d",&a[i]);
		cin>>a[i];
		aa[i]=a[i];
	}
	arr[n-1]=0;
  long long inv=0;
  for (int i = n-1; i>=0; --i)
  {
    inv+=(query(aa[i]-1,tree));
      update(aa[i],1,1000000,tree);
  }
  
	sort(a.begin(),a.end());
  int k=0;
  for (int i = 0; i < n; ++i)
  {
     m[a[i]]=k++;
  }
	for (int i = 0; i < n; ++i)
	{	
		
    int bg=m[aa[i]];
    int fg=n-m[aa[i]]-1;
    inv-=bg;
    inv+=fg;
    
    // cout<<tree1[1]<<" ";
   
    // cout<<*it<<" "<<fg<<endl;
    cout<<inv<<" ";
		
	}
	cout<<endl;


}
 	return 0;
}