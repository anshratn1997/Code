#include<iostream>
#include<vector>
#include<stdio.h>
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
using namespace std;
int main()
{
     int n;
     freopen("b.txt","r",stdin);
     cin>>n;
     vector<int> a(n);
     int _2=0,_1=0;
     for(int i=0;i<n;i++)
     {
         cin>>a[i];
         if(a[i]%2==0)
            _2++;
         else
            _1++;
     }
     if(_2>_1)
        cout<<"READY FOR BATTLE";
     else
   cout<<"NOT READY";
    return 0;
}
