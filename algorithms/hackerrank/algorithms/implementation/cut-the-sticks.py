import sys

n = int(raw_input().strip())
arr = map(int, raw_input().strip().split(' '))
print n
for s in range(0, n):
    m = min([x for x in arr if x > 0])
    arr[:] = [x - m for x in arr]
    r = sum(x > 0 for x in arr)
    if r > 0:
        print r
    else:
        sys.exit(0)
