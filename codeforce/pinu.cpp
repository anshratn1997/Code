#include<bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	cin>>n;
	long long x,k;
	cin>>x;
	cin>>k;
	std::vector<long long> v(n);
	for (int i = 0; i < n; ++i)
	{
		cin>>v[i];
	}
	sort(v.begin(),v.end());
	std::vector<long long>::iterator i,up;
	int ans=0;
	i=v.begin();
	while(i!=v.end())
	{
		long long temp=v[*i]-x;
		temp+=x*k;
		up=upper_bound(i+1,v.end(),temp-1);
			ans+=(up-i);
	    if(k==0 || v[*i]%x==0)
	    	ans+=1;
		i++;
	}
	cout<<ans<<endl;
	return 0;
}