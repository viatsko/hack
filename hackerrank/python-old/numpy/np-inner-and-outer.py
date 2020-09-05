import numpy

A = map(int, raw_input().strip().split(' '))
B = map(int, raw_input().strip().split(' '))

print numpy.inner(A, B)
print numpy.outer(A, B)
