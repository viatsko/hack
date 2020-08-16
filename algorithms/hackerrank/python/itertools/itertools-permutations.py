import itertools

a, b = raw_input().split()

for e in itertools.permutations(sorted(a), int(b)):
    print(''.join(e))
