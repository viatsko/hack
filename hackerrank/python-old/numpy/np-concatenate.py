import numpy

N, M, P = map(int, raw_input().strip().split(' '))

arr1 = []
arr2 = []

for _ in range(0, N):
    arr1.append(map(int, raw_input().strip().split(' ')))

for _ in range(0, M):
    arr2.append(map(int, raw_input().strip().split(' ')))

print numpy.concatenate((arr1, arr2))
