import numpy

arr = []
N, M = map(int, raw_input().strip().split(' '))
for _ in range(0, N):
    arr.append(map(int, raw_input().strip().split(' ')))

my_array = numpy.array(arr)
print numpy.transpose(my_array)
print my_array.flatten()
