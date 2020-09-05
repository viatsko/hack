n, m = map(int, raw_input().strip().split(' '))
S = list(raw_input().strip().split(' '))
A = set(raw_input().strip().split(' '))
B = set(raw_input().strip().split(' '))

happiness = 0

for s in S:
    if s in A:
        happiness += 1
    if s in B:
        happiness -= 1

print happiness
