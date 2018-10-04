t=int(input())
n,m=map(int,input().split())
s1=input()
s2=input()
sb1=""
sb2=""
tt=1;
sb1+=s1[n-1]
for x in xrange(n-2,0,-1):
	if(s1[i]==s1[i+1]):
		tt+=1
	else:
		sb1+=s1[i]
		tt=1
