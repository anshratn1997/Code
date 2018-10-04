#include<bits/stdc++.h>
#define sync ios::sync_with_stdio(0);cin.tie(0);
#define ll long long
#define M 1000000007
using namespace std;
int main(){
sync;
#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif
int t;
cin>>t;
while(t--){
ll a,b;
cin>>a>>b;
std::vector<ll> v1,v2,v3;
while(a){
	v1.push_back(a%10);
	a/=10;
	}
while(b){
	v2.push_back(b%10);
	b/=10;
	}








for (int i = 0; i < min(v1.size(),v2.size()); ++i)
		{
			/* code */v3.push_back((v1[i]+v2[i])%10);
		}
		int x=0;
if(v1.size()>v2.size())
for (int i = v1.size()-1; i >=min(v1.size(),v2.size()) ; i--)
{
	/* code */x=x*10+v1[i];
}
else
for (int i = v2.size()-1; i >=min(v1.size(),v2.size()) ; i--)
{
	/* code */x=x*10+v2[i];
}


for (int i = v3.size()-1; i >=0 ; i--)
				{
					/* code */
					x=x*10+v3[i];

				}				

	cout<<x<<endl;
}
return 0;	
}