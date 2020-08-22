d = {}
n = int(raw_input())

for _ in range(0, n):
    name = raw_input()
    score = float(raw_input())
    
    if score in d:
        d[score].append(name)
    else:
        d[score] = [name]

ans = d[sorted(d)[1]]
ans.sort()
        
for x in ans:
    print x
