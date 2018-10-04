#include<bits/stdc++.h>
using namespace std;
#define mod 1000000007
unsigned long long modularExponentiation(unsigned long long  x,unsigned long long int n)
{
    unsigned long long result=1;
    while(n>0)
    {
        if(n % 2 ==1)
            result=(result * x)%mod;
        x=(x*x)%mod;
        n=n/2;
    }
    return result%mod;
}
int main()
{

 // cout<<fast_exp(10,5);
    int t;
    //freopen("b.txt","r",stdin);
    scanf("%d",&t);

    while(t--)
    {
        int n,q;
        scanf("%d%d",&n,&q);
        vector<unsigned long long int> a(n+1);
        a[0]=1;
        for(int i=1;i<=n;i++)
            scanf("%llu",&a[i]);
        for(int i=1;i<=q;i++)
        {
              unsigned long long int x;
              scanf("%llu",&x);
              unsigned long long int ans=0;
              if(n<4 && x<=4)
              {
                 if(n==1)
                 {
                     ans=modularExponentiation(a[1],x);
                     ans=ans%mod;
                     printf("%llu ",ans);
                 }
                 else if(n==2)
                 {
                        unsigned long long int s2,s1=a[1];
                        unsigned long long int t1=s1*s1;
                        unsigned long long int t2=(t1%mod)*s1;
                        unsigned long long int t3=(t1%mod)*(t1%mod);
                        //cout<<t1<<" "<<t2<<" "<<t3<<endl;

                       s2=((t1%mod)-a[2])/2;
                       //cout<<s2<<endl;
                       if(x==3)
                          ans=((t2%mod)-(3*((s2*s1)%mod))%mod)%mod;
                       if(x==4)
                        ans=((t3)%mod-(4*((s2*a[2])%mod))%mod-(6*((s2*s2)%mod))%mod)%mod;
                       //cout<<(4*((s2*a[2])%mod))%mod<<endl;
                       //cout<<(6*(t1%mod))%mod<<endl;
                       printf("%llu ",ans);
                 }
                 else if(n==3)
                 {
                        unsigned long long int s1=a[1],s2,s3;
                        unsigned  long long int t1=s1*s1;
                        unsigned long long int t2=(t1%mod)*s1;
                        unsigned   long long int t3=(t1%mod)*(t1%mod);
                        //cout<<t1<<endl;
                       s2=((t1%mod-a[2])%mod)/2;
                      // cout<<t1-a[2]<<endl;
                       s3=((a[3]+(3*(s2*s1)%mod)%mod-(t2%mod))%mod)/3;
                       ans=((t3)%mod-(4*((s2*a[2])%mod))%mod-(6*((s2*s2)%mod))%mod+(4*((s3*s1)%mod))%mod)%mod;
                       printf("%llu ",ans);
                 }
              }
              else{
                ans=0;
                printf("0 ");}
        }
        printf("\n");
    }
    return 0;
}
