import itertools

s = input().strip()

dim = int(len(s) ** 0.5)
if dim * dim == len(s):
    x, y = dim, dim
else:
    x, y = dim, dim + 1

array = [s[i: i + y] for i in range(0, len(s), y)]

transpose = itertools.zip_longest(*array, fillvalue='')

print(' '.join(''.join(s) for s in transpose))
