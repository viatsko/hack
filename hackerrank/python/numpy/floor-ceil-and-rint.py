import numpy

arr = numpy.array(map(float, raw_input().strip().split(' ')))

print numpy.floor(arr)
print numpy.ceil(arr)
print numpy.rint(arr)
