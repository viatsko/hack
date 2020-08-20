t = int(raw_input())
for _ in range(0, t):
    n = int(raw_input())
    c = 0
    for d in str(n):
        d = int(d)
        if d != 0 and n % d == 0:
            c += 1
    print c
