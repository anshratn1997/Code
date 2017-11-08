#include <bits/stdc++.h>
using namespace std;
int fun1(int n){
	static int x=0;
	x++;
	if(n>0)
		return fun1(n-1);
	return x;

}
void fun2(int *x,int *y){
	int *t;
	t=x;
	x=y;
	y=t;
}
int main(){
  int a=3,b=4;
  int res=fun1(a)+fun1(b);
  fun2(&a,&b);
  int re=res+a;
  cout<<re;
  return 0;
}