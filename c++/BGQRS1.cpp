#include<bits/stdc++.h>
using namespace std;
#define cout(x) cout<<x<<endl;
#define coutl(x) cout<<x<<" ";
#define couts(x) cout<<"x"<<" ";
#define ok cout<<"ok"<<endl;
int main()
{
long long t;
//freopen("b.txt","r",stdin);
scanf("%lld",&t);
while(t--)
{
long long n,m;
scanf("%lld%lld",&n,&m);
struct element
{
    long long int a;
    int c_2;
    int c_5;
}a[n+1];
a[0].a=0;
a[0].c_2=0;
a[0].c_5=0;
for(long long i=1;i<=n;i++){
  scanf("%lld",&a[i].a);
  long long temp=a[i].a;
       int c2=0,c5=0;
        while(temp!=0)
        {
            if(temp%2==0)
            {
                c2++;
                temp/=2;
            }
            else
                break;
        }
        a[i].c_2=c2;
        temp=a[i].a;
        while(temp!=0)
        {
            if(temp%5==0)
            {
                c5++;
                temp/=5;
            }
            else
                break;
        }
        a[i].c_5=c5;
}
long long ans=0;
  while(m--)
  {
      long long type,l,r,x,y;
      scanf("%lld",&type);
      if(type==1){
        scanf("%lld%lld%lld",&l,&r,&x);
        long long temp=x;
        int c2=0,c5=0;
        while(temp!=0)
        {
            if(temp%2==0)
            {
                c2++;
                temp/=2;
            }
            else
                break;

        }
        temp=x;
        while(temp!=0)
        {
            if(temp%5==0)
            {
                c5++;
                temp/=5;
            }
            else
                break;
        }
      for(long long i=l;i<=r;i++)
      {
             a[i].c_2+=c2;
             a[i].c_5+=c5;
      }
    }
      if(type==2){
        scanf("%lld%lld%lld",&l,&r,&y);
        for(long long i=l;i<=r;i++)
        {
            a[i].a=(i-l+1)*y;
            long long temp1=a[i].a;
            int count_5=0,count_2=0;
            while(temp1!=0)
            {
               if(temp1%5==0){
                count_5++;
                temp1/=5;}
                else
                    break;
            }
            a[i].c_5=count_5;
            temp1=a[i].a;
            while(temp1!=0)
            {
               if(temp1%2==0){
                count_2++;
                temp1/=2;}
                else
                    break;
            }
            a[i].c_2=count_2;

        }
        }
       if(type==3){
        scanf("%lld%lld",&l,&r);
        int count_5=0,count_2=0;
        for(long long i=l;i<=r;i++)
         {

             count_2+=a[i].c_2;
             count_5+=a[i].c_5;
         }
         //cout(count_2);
         //cout(count_5);
          ans+=min(count_2,count_5);
        }
        //cout(ans);
  }
  printf("%lld\n",ans);
}
return 0;
}
