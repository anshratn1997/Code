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
        int a=0,b=0;
        for(int i=0;i<len;i++)
        {
            if(st[i]=='0')
                a++;
            else
                b++;
        }
        if(a==1||b==1)
            cout<<"Yes"<<endl;
        else
            cout<<"No"<<endl;
    }
    return 0;
}
