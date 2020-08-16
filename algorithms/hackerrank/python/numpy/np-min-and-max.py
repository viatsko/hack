import numpy

N, M = map(int, raw_input().strip().split(' '))

arr = []

for _ in range(0, N):
    arr.append(map(int, raw_input().strip().split(' ')))

print numpy.max(numpy.array(numpy.min(numpy.array(arr), axis=1)))
