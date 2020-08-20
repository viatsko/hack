from math import *

t = int(raw_input())
for a0 in range(0, t):
    a, b = map(int, raw_input().strip().split(' '))
    print int(floor(sqrt(b)) - ceil(sqrt(a)) + 1)
