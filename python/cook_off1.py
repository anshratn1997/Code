n=int(input())
l=["Beginner","Junior Developer", "Middle Developer","Senior Developer","Hacker","Jeff Dean"]
for i in range(n):
	temp=[int(x) for x in input().split(" ")]
	sum=0
	for j in range(len(temp)):
		sum+=temp[j]
	print(l[sum])

