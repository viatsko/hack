n = int(raw_input())

gems = {}

for _ in xrange(n):
    g = list(raw_input())
    unique = []
    [unique.append(item) for item in g if item not in unique]
    for el in unique:
        if el in gems:
            gems[el] += 1
        else:
            gems[el] = 1

cnt = 0
for i in gems:
    if gems[i] == n:
        cnt += 1

print cnt