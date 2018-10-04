#include <iostream>
#include <stdio.h>
using namespace std;
int knapSack(int W, int wt[], int val[], int n)
{
   int i, w;
   int K[n+1][W+1];
 
   // Build table K[][] in bottom up manner
   for (i = 0; i <= n; i++)
   {
       for (w = 0; w <= W; w++)
       {
           if (i==0 || w==0)
               K[i][w] = m;
           else if (wt[i-1] <= w)
                 K[i][w] = min(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
           else
                 K[i][w] = K[i-1][w];
       }
   }
   
   for (int i = 0; i < 4; ++i)
   {
     for (int j = 0; j < 4; ++j)
     {
       cout<<K[i][j]<<" ";
     }
     cout<<endl;
   }
 
   return K[n][W];
}
 int m;
int main()
{
   // int val[] = {60, 100, 120};
    //int wt[] = {10, 20, 30};
    //int  W = 50;
    //int n = sizeof(val)/sizeof(val[0]);
    int n,a,b,c;
      cin>>n>>a>>b>>c;
      m=max(a,(max(b,c))); 
     m=m*3;
    int req=0;
    if(n>4)
      req=4-n%4;
    else
      req=4-n;
    //cout<<req;
    int wt[]={1,2,3};
    int val[3];
    val[0]=a;
    val[1]=b;
    val[2]=c;  
    printf("%d", knapSack(req, wt, val, 3));
    return 0;
}
