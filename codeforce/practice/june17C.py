t=int(input())
while t!=0:	
     n=int(input())
     a=list(map(int,input().split(" ")))
     a.sort(reverse=True)
     count=0
     sum_positive=0
     sum_negative=0
     i=0
     while a[i]>=0 and i<n:
           sum_positive+=a[i]
           count+=1
           i+=1
     while i<n:
          if (sum_positive+a[i])*(count+1)>=sum_positive*count:
              sum_positive+=a[i]
              count+=1
          else:
              sum_negative+=a[i]
          i+=1    
     print(sum_negative+count*sum_positive)        
     t-=1        
            