#include<bits/stdc++.h>
using namespace std;
#define ok cout<<"ok"<<endl;
int main()
{
    int t;
    //freopen("b.txt","r",stdin);
    cin>>t;
    while(t--){
    string s1,s2,s3;
    cin>>s1;
    cin>>s2;
    cin>>s3;
    int n;
    cin>>n;
    int no_of_1=0;
    bool first_0=false;
    int no_1=0;
     int n_1=0;
    for(int l=s2.size()-1;l>=0;l--)
     {
         if(s2[l]=='0')
            break;
         else if(s2[l]=='1')
            n_1++;
     }
     //cout<<n_1<<endl;
    for(int l=s3.size()-1;l>=0;l--)
    {
        if(s3[l]=='0' && !first_0)
            first_0=true;
        if(s3[l]=='1' && first_0)
            no_of_1++;
    }
// cout<<no_of_1<<endl;
    if(!first_0){
    for(int l=s2.size()-1;l>=0;l--)
    {
        if(s2[l]=='0' && !first_0)
          first_0=true;
        if(s2[l]=='1' && first_0)
            no_of_1+=n;
      //cout<<no_of_1<<endl;
     }
       if(first_0)
     no_of_1=no_of_1+n_1*(n-1);
   }
   else
   {
          for(int l=s2.size()-1;l>=0;l--)
                  if(s2[l]=='1')
                     no_of_1+=n;
   }
   //cout<<no_of_1<<endl;
    for(int l=s1.size()-1;l>=0;l--)
    {
        if(s1[l]=='0' && !first_0)
          first_0=true;
        if(s1[l]=='1' && first_0)
            no_of_1++;
    }
    cout<<no_of_1+1<<endl;


 }
 return 0;
}
