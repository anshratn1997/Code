for t1 in range(int(input())):
	line=[int(x) for x in input().split(" ")]
	n=line[0]
	a=line[1]
	b=line[2]
	c=line[3]
	m=max(line[1:])
	m=min(m,n//2)
	l=list()
	dic={}
	for i in range(1,m+1):
		if(n%i==0):
			l.append(i)
			dic[i]=1
	count=0
	# print(len(l))
	for i in range(len(l)):
		if(l[i]>a):
			break
		for j in range(len(l)):
			if(l[j]>b):
				break
			req=n//(l[i]*l[j])
			if((req in dic ) and req<=c):
				# print(l[i],l[j],req)
				if(req*l[i]*l[j]==n):
					count+=1
	print(count)