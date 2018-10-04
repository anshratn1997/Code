#include <bits/stdc++.h>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t-->0){
	int n,q;
	cin>>n>>q;
	int a[n];
	for (int i = 0; i < n; ++i)
	{
		/* code */
		cin>>a[i];
	}
	set<int> sl,sr;
	sl.insert(a[0]);
	sr.insert(a[n-1]);
	int left[n];
	int right[n];
    left[0]=0;
    right[n-1]=0;
	for (int i = 1; i <=n-1; ++i)
	{  
          set<int>:: iterator it=sl.upper_bound(a[i]);
         if(it==sl.begin())
         {
             if(*it>a[i])
             	left[i]=0;
             else
             	left[i]=*it;
         }
         else{
         	 it--;
         	 left[i]=*it;
         }
         sl.insert(a[i]);

	}
	for (int i = n-2; i>=0; --i)
	{    
         set<int>:: iterator it=sr.upper_bound(a[i]);
         if(it==sr.begin())
         {
             if(*it>a[i])
             	right[i]=0;
             else
             	right[i]=*it;
         }
         else{
         	 it--;
         	 right[i]=*it;
         }

         
         sr.insert(a[i]);
        
	}
	
	for (int i = 0; i < q; ++i)
	{
		int ind;
		cin>>ind;
		ind--;
		long long lt=left[ind];
		long long rt=right[ind];
		long long mt=a[ind];
		long long ans=lt*rt*mt;
		cout<<ans<<endl;
			
 	}

}
 	return 0;
}