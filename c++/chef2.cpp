#include<bits/stdc++.h>
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string st;
        cin>>st;
        int len=st.size();
        int i=0;
        for(i=0;i<len/2;i++)
        {
            if(st[i]==st[len-1-i] && st[i]!='.')
                continue;
            else if(st[i]==st[len-1-i] && st[i]=='.')
                 st[i]='a',st[len-i-1]='a';
            else if(st[i]=='.')
                  st[i]=st[len-i-1];
             else if(st[len-i-1]=='.')
                 st[len-i-1]=st[i];
             else
                break;

        }
        if(st[len/2]=='.')
            st[len/2]='a';

        if(i==len/2)
            cout<<st<<endl;
        else
            cout<<"-1"<<endl;
    }
    return 0;
}
