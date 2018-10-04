#include "bits/stdc++.h"
using namespace std;
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 1000001;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;

bool prime[MAX+1];
//bool special[MAX+1];
void PRIME()
{
   

    for (int p=2; p<=MAX; p++)
    {
        if (prime[p] == true)
        {
           
            for (int i=p*2; i<=MAX; i += p){
                
                   prime[i] = false;
               }

        }
    }
}

int main(){
 memset(prime, true, sizeof(prime));
  
	prime[0]=false;
	prime[1]=false;
	PRIME();
	int t;
	cin>>t;
	while(t--)
	{
	long long n;
	cin>>n;
	vector< long long > v;
	vector<long long > sp;
	//int sp=0;
	for (int i = 1; i <=n; ++i)
	{
		if(n%i==0 && !prime[i]){
			v.push_back(i);
			//cout<<i<<" ";
		}
		if(n%i==0 && prime[i])
			sp.push_back(i);

	}
	int ans=0;
	for (int i = 0; i < sp.size()-1; ++i)
	{
		for (int j = i+1; j <sp.size(); ++j)
		{
			long long rem=n/(sp[i]*sp[j]);
			if(prime[rem] && n%rem==0){
				ans=-1;
				break;
			}
		}
		if(ans==-1)
			break;
	}
	if(ans==-1)
		cout<<ans<<endl;
	else{
	for (int i = 0; i <v.size()-1; ++i)
	{
        for (int j = i+1; j < v.size(); ++j)
        {
        	
        		if(v[i]*v[j]==n){
        			ans++;
        		
        	 // cout<<v[i]<<" "<<v[j]<<" ";
        	}
        	
        }
	}
	
	cout<<ans<<endl;
}
}

    return 0;
}

