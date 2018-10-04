#include<bits/stdc++.h>
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
using namespace std;
char st[1004];
int t=26;
int main()
{

    int n,m;
 // freopen("b.txt","r",stdin);
     scanf("%d%d",&n,&m);
     bool  a1[n][t];
     bool a2[m][t];
     for(int i=0;i<n;i++)
         for(int j=0;j<26;j++)
              a1[i][j]=false;

      for(int i=0;i<m;i++)
         for(int j=0;j<26;j++)
              a2[i][j]=false;

    //for(int i=0;i<n;i++)
      //   for(int j=0;j<26;j++)
        //      cout<<a1[i][j];


   vector<string> ss1;
   vector<string> ss2;
   int j=n,i=m;
while(j--)
{
            scanf("%s",st);
            ss1.push_back(st);
            memset(st,'\0',sizeof(char));

}
while(i--)
{
            scanf("%s",st);
            ss2.push_back(st);
             memset(st,'\0',sizeof(char));

}
for(int k=0;k<n;k++)
{
    string ct=ss1[k];
    int sz=ct.size();
    for(int l=0;l<sz;l++)
    {
           int index=ct[l]-65;
            a1[k][index]=1;
    }
}
/*
for(int i=0;i<n;i++){
         for(int j=0;j<26;j++){
              cout<<a1[i][j];}
              cout<<endl;}*/

for(int k=0;k<m;k++)
{
    string ct=ss2[k];
    int sz=ct.size();
    for(int l=0;l<sz;l++)
    {
           int index=ct[l]-65;
            a2[k][index]=1;
    }
}
int res=0;
 for(int k=0;k<n;k++)
 {
     for(int l=0;l<m;l++)
     {
         int ans=0;
         for(int ii=0;ii<26;ii++)
         {
             if(a1[k][ii]==0 && a2[l][ii]==0){
                ans=1;
               // cout<<"hello "<<k<<" "<<l<<" "<<ii<<" ";
                break;}
         }
         if(!ans)
            res++;
     }
 }
printf("%d",res);
    return 0;
}
