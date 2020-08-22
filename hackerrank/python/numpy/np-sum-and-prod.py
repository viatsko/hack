import numpy

N, M = map(int, raw_input().strip().split(' '))

arr = []

for _ in range(0, N):
    arr.append(map(int, raw_input().strip().split(' ')))

arr = numpy.array(arr)

print numpy.prod(numpy.array(numpy.sum(arr, axis=0)))
