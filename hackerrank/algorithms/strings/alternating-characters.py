n = int(raw_input())
for _ in range(n):
    s = list(raw_input())
    count = 0
    for i in xrange(len(s) - 1):
        if s[i] == s[i + 1]:
            count += 1
    print count