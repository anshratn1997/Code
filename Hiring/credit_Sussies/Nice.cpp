#include<bits/stdc++.h>
using namespace std;
int main(){
	int n,q;
	cin>>n>>q;
	set<int> st;
	for (int i = 0; i < q; ++i)
	{
		int type,x;
	    cin>>type>>x;
	    if(type==1)
	    	 {
	    	 	st.insert(x);
	    	}
	    else{
	    set<int> :: iterator it=st.upper_bound(x-1);
	     if(st.size()==0 || it==st.end())
	     cout<<"-1"<<endl;
	    else
	    	cout<<*it<<endl;
	  }
	}
}