#include<bits/stdc++.h>
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
using namespace std;
int a[1000][1000];
int maxSubArraySum(vector<int > &a, int size)
{
    int max_so_far = 0, max_ending_here = 0;

    for (int i = 0; i < size; i++)
    {
        max_ending_here = max_ending_here + a[i];
        if (max_ending_here < 0)
            max_ending_here = 0;
        if (max_so_far < max_ending_here)
            max_so_far = max_ending_here;
    }
    return max_so_far;
}
int readInt () {
	bool minus = false;
	int result = 0;
	char ch;
	ch = getchar_unlocked();
	while (true) {
		if (ch == '-') break;
		if (ch >= '0' && ch <= '9') break;
		ch = getchar();
	}
	if (ch == '-') minus = true; else result = ch-'0';
	while (true) {
		ch = getchar();
		if (ch < '0' || ch > '9') break;
		result = result*10 + (ch - '0');
	}
	if (minus)
		return -result;
	else
		return result;
}
int main()
{
    int t;
   // freopen("b.txt","r",stdin);
    t=readInt();
    vector<pair<int ,int> > row;
    vector<pair<int ,int > > col;
    while(t--)
    {
        int n,m;
        scanf("%d%d",&n,&m);
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=0;j<n;j++)
            {
                a[i][j]=readInt();
                sum+=a[i][j];
            }
            row.push_back(make_pair(sum,i));
        }
        for(int i=0;i<m;i++)
        {
            int sum=0;
            for(int j=0;j<n;j++)
            {
                sum=sum+a[j][i];
            }
            col.push_back(make_pair(sum,i));
        }
        sort(row.begin(),row.end());
        sort(col.begin(),col.end());
        int r=row[0].second;
        int c=col[0].second;
        //cout(r);
        //cout(c);

        int ans=0;
        int sum1=0,sum2=0,sum3=0,sum4=0;
        vector<int > a1;
        vector<int > a2;
        vector<int > a3;
        vector<int > a4;
        bool _check=false;
        for(int i=0;i<c;i++)
        {
           a1.push_back(a[r][i]);
           sum1+=a[r][i];
        }
        sum1=sum1-maxSubArraySum(a1,a1.size());

    //    cout(sum1);
        for(int i=m-1;i>c;i--)
        {
           a2.push_back(a[r][i]);
           sum2+=a[r][i];
        }
        sum2=sum2-maxSubArraySum(a2,a2.size());
      //  cout(sum2);
        for(int i=0;i<r;i++)
        {
           a3.push_back(a[i][c]);
           sum3+=a[i][c];
        }
        sum3=sum3-maxSubArraySum(a3,a3.size());
        //cout(sum3);
        for(int i=n-1;i>r;i--)
        {
           a4.push_back(a[i][c]);
           sum4+=a[i][c];
        }
        //cout(maxSubArraySum(a4,a4.size()));
        sum4=sum4-maxSubArraySum(a4,a4.size());
         //cout(sum4);
        ans=sum1+sum2+sum3+sum4+a[r][c];
       printf("%d\n",ans);
    }
    return 0;
}
