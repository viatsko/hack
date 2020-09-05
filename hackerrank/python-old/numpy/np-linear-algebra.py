import numpy

x = int(raw_input().strip())

arr = []

for _ in range(0, x):
    arr.append(map(float, raw_input().strip().split(' ')))

print numpy.linalg.det(arr)
