import bisect
t=int(input())
while t>0:
	n,q=map(int,input().split(" "))
	l=[]
	for i in range(n):
		l.append(i);
	left=[]
	right=[]
	p={}
	q={}
	left.append(l[0])
	right.append(l[n-1])
	for i in range(1,n):
		j = bisect.bisect_left(left, l[i])
		p[i]=(left[j-1])
		bisect.insort(left,l[i])

	for i in range(n-1,0,-1):
		j = bisect.bisect_left(right, l[i])
		q[i]=(right[j-1])
		bisect.insort(left,l[i])
	for i in range(1,n):
		print(p[i])	
	t=t-1