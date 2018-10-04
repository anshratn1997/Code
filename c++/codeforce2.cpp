#include<bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(false);
    string s;
    cin>>s;
    int a[4]={0,0,0,0};
    for(int i=0;i<s.size();i++){
     if(s[i]=='L')
          a[0]++;
     else if(s[i]=='R')
        a[1]++;
     else if(s[i]=='U')
        a[2]++;
     else
        a[3]++;
    }
   // cout<<a[0]<<a[1]<<a[2]<<a[3];
      if(abs(a[0]-a[1])==abs(a[2]-a[3]))
         cout<<abs(a[0]-a[1]);
      else
        cout<<"-1";
return 0;
}
