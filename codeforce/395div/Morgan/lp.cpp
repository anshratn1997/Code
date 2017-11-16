

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
	ll n;
	cin>>n;
	ll A[n];
	for(int i=0;i<n;i++) cin>>A[i];
	sort(A,A+n);
	int sum=0;
	if(n==1){
		sum=A[0]*1LL;
	cout<<sum<<endl;
	}
	else if(n==2){
		sum=(A[0]+A[1])*1LL;
//		ll p=GCD(sum,n);
//		sum=sum/x;
//		n=n/x;
		if(sum%2==0)
			cout<<sum/2<<endl;
		else
			cout<<sum<<"/"<<2<<endl;
	}
	else{
		sum=(3*A[0]+3*A[n-1])*1LL;
		for(int i=1;i<n-1;i++)
			sum+=(A[i]*2);
		
		if(sum%6==0)
			cout<<sum/6<<endl;
		else if(sum%2==0)
			cout<<sum/2<<"/"<<3<<endl;
		else if(sum%3==0)
			cout<<sum/3<<"/"<<2<<endl;
		else  
			cout<<sum<<"/"<<6<<endl;
	}

	}
return 0;	
}