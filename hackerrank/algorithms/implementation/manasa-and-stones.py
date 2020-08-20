from itertools import groupby

T = int(input())

for _ in range(T):
    n = int(input())
    ab = int(input()), int(input())
    a, b = min(ab), max(ab)

    sg = ((n - i - 1) * a + i * b for i in range(n))
    print(*(k for k, g in groupby(sg)))
