#include <bits/stdc++.h>
using namespace std;

int main()
{
	 // ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	 int t=1;
	 scanf("%d",&t);
	 while(t-->0){
	 int n,m;
	 scanf("%d%d",&n,&m);
	 char s1[n];
	 char s2[m];
	 scanf("%s",s1);
	 scanf("%s",s2);
	
	pair<int ,char> mat[n+1][m+1];
	mat[0][0]=make_pair(0,'0');
	for (int i = 1; i <= n; ++i)
	{
		 if(mat[i-1][0].second!=s1[i-1])
          mat[i][0]=make_pair(mat[i-1][0].first+1,s1[i-1]);
        else
          mat[i][0]=make_pair(mat[i-1][0].first,s1[i-1]);
	}
	for (int i = 1; i <= m; ++i)
	{
		 if(mat[0][i-1].second!=s2[i-1])
          mat[0][i]=make_pair(mat[0][i-1].first+1,s2[i-1]);
        else
          mat[0][i]=make_pair(mat[0][i-1].first,s2[i-1]);
	}
	 for (int i=1;i<=n ; i++) {
          for (int j=1;j<=m ;j++ ) {
             int vv2=mat[i-1][j].first,vv1=mat[i][j-1].first;
             char ch2=mat[i-1][j].second,ch1=mat[i][j-1].second;
             if(s2[j-1]!=ch1)
               vv1++;
             if(s1[i-1]!=ch2)
              vv2++;
             if(vv1>vv2)
              mat[i][j]=make_pair(vv2,s1[i-1]);
             else
              mat[i][j]=make_pair(vv1,s2[j-1]);
 
          }
       }
       printf("%d\n", mat[n][m].first);


}


	return 0;
}