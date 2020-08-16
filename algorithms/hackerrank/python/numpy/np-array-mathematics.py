import numpy

N, M = map(int, raw_input().strip().split(' '))

A = []
B = []

for _ in range(0, N):
    A.append(map(int, raw_input().strip().split(' ')))
for _ in range(0, N):
    B.append(map(int, raw_input().strip().split(' ')))

A = numpy.array(A)
B = numpy.array(B)

print A + B
print A - B
print A * B
print A / B
print A % B
print A ** B
