import itertools

a, b = raw_input().split()

for e in itertools.combinations_with_replacement(sorted(a), int(b)):
    print ''.join(e)
