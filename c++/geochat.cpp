#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    scanf("%d",&n);
    vector<pair<int,int> > point;
    for(int i=0;i<n;i++)
    {
        int x,y;
        scanf("%d%d",&x,&y);
        point.push_back(make_pair(x,y));
    }
        printf("0\n");
                    unsigned long long int ans=0;

        for(int i=1;i<point.size();i++)
        {
             for(int j=0;j<i;j++)
             {
                  unsigned long long int d=0;
                  d=pow((point[i].first-point[j].first),2) + pow((point[i].second-point[j].second),2);
                  if(ans<=d)
                    ans=d;

             }
             printf("%llu\n",ans);
        }
    return 0;
}
