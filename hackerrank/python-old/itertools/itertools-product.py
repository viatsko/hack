import itertools

a = list(map(int,raw_input().split()))
b = list(map(int,raw_input().split()))

print(' '.join(str(e) for e in itertools.product(a,b)))
