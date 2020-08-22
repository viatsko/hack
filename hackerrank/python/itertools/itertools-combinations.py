import itertools

a, b = raw_input().split()

for i in range(1, int(b)+1):
    for e in itertools.combinations(sorted(a), i):
        print ''.join(e)
