import numpy

N, M = map(int, raw_input().strip().split(' '))

arr = []

for _ in range(0, N):
    arr.append(map(int, raw_input().strip().split(' ')))

narr = numpy.array(arr, dtype=float)

print numpy.mean(narr, axis=1)
print numpy.var(narr, axis=0)
print numpy.std(narr, axis=None)
