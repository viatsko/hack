import numpy

N = int(raw_input().strip())

A = []
B = []

for _ in range(0, N):
    A.append(map(int, raw_input().strip().split(' ')))

for _ in range(0, N):
    B.append(map(int, raw_input().strip().split(' ')))

print numpy.dot(A, B)
