import math

t = int(raw_input())
for _ in range(0, t):
    n = int(raw_input())
    power = int(math.ceil(n / 2.0)) + 1
    base = 2 ** power
    if n % 2 == 0:
        print base - 1
    else:
        print base - 2
