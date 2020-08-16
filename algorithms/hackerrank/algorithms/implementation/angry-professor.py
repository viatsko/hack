t = int(raw_input().strip())

for _ in range(0, t):
    n, k = map(int, raw_input().strip().split(' '))
    a = map(int, raw_input().strip().split(' '))
    c = 0
    for s in a:
        if s <= 0:
            c += 1
    if c < k:
        print "YES"
    else:
        print "NO"
