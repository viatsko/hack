import numpy

arr = map(float, raw_input().strip().split())
x = float(raw_input().strip())

print numpy.polyval(arr, x)
