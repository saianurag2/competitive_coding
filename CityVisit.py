import bisect
n = int(input())
array = list(map(int, input().split()))
m = int(input())
costly_cities = list()
#print(n)
#print(m)
#print(array)
if array[n-1] == -1:
    print('-1')
    exit()
min_count = 0
total_cost = 0
for ind in range(n):
    if array[ind] == -1:
        min_count =  min_count + 1
        continue
    else:
        total_cost = total_cost + array[ind]
        if len(costly_cities) < m:
            bisect.insort(costly_cities,array[ind])
        elif costly_cities[0] < array[ind]:
            costly_cities.remove(costly_cities[0])
            bisect.insort(costly_cities,array[ind])
if min_count > m:
    print('-1')
elif min_count == m:
    print(total_cost)
else:
    skips = m - min_count
    deduct = 0
    if skips < len(array):
        deduct = sum(array[-skips:])
        print(total_cost-deduct)
    else:
        print(array[n-1])
    
    
