import numpy

dim = map(int, raw_input().strip().split(' '))

print numpy.zeros(dim, dtype=numpy.int)
print numpy.ones(dim, dtype=numpy.int)
