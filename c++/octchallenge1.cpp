#include<bits/stdc++.h>
using namespace std;
unsigned long long  ncr(unsigned long long int n,unsigned long long int r)
{
    if(r<=n){
    if(r>n/2)
        r=n-r;
    unsigned long long nume=1;
    unsigned long long denom=1;
    unsigned long long result=0;
    for(int i=r;i>=1;i--)
    {
        nume=nume*n;
        n--;
        denom=denom*i;

    }
    if(denom>=1)
    result=nume/denom;
    else
        result=1;
    return result;
    }
    else
        return 0;
}
int main()
{
    int n;
    scanf("%d",&n);
    vector<int> arr(n);
    vector<int> a;
     unsigned long long int sum=0;
   unsigned  long long int  count=0,_1=0,_2=0,_3=0;
    for(int i=0;i<n;i++)
    {

        scanf("%d",&arr[i]);
        if(arr[i]==1){
           a.push_back(arr[i]);
           _1++;}
        else if(arr[i]==2){
           a.push_back(arr[i]);
           _2++;}
        else if(arr[i]==3)
            _3++;
        else
            count++;
    }
    //cout<<a.size()<<endl;
       unsigned long long sz=a.size();
    if(sz>=3)
    {
         // cout<<1<<" ";
        sum=sum+ncr(sz,3)+ncr(_2,1)*ncr(_1,2)+2*ncr(_1,3) - ncr(_2,3)+ncr(_2,1)*ncr(_1,1)*ncr(_3,1)+ncr(_1,2)*ncr(_3,1)+ncr(_1,2)*count;

    }
   else if(a.size()==2 && ((a[0]==1 && a[1]==2)||(a[0]==2 && a[1]==1)))
   {
      //cout<<2<<" ";
       sum=sum+_3;
   }
   else if(a.size()==1)
   {
      // cout<<3<<" ";
      sum=0;
   }



    printf("%llu",sum);
    return 0;
}
