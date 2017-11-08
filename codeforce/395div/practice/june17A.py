t=int(input())
while t!=0 :
    n=int(input())
    
    if n<=2:
        if n==1:
           print(n)
        else:
           print(1,2)
    else:
        nolist=[1,2]
        for i in range(3,501):
            ans=True
            for a in range(len(nolist)-1):
                for b in range(a+1,len(nolist)):
                    if nolist[a]+nolist[b]==i:
                        ans=False
                        break;

                if ans==False:
	                break
            if ans!=False:
               nolist.append(i)
            if len(nolist)==n:
               break
        for i in range(len(nolist)):
             print(nolist[i],end=' ')
        print()           
    t=t-1
	