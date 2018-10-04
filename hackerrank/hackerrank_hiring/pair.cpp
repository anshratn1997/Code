#include<bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	cin>>n;
	vector ff[10];
	for (int i = 0; i < n; ++i)
	{
		/* code */
	  string line;
	  cin>>line;
	  int hash[10];
	  for (int i = 0; i < line.length(); ++i)
	  {
	  	/* code */
	  	 hash[line[i]-48]=1;

	  }
	  for (int j = 0; j < 10; ++j)
	  {
	  		if(hash[j])
	  			ff[j].push_back(i);
	  }
	}
	int sz=(int)Math.pow(2,10);
    int ssi[sz];
    memset(sz,0,sizeof(int));
    
}