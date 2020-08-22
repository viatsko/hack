from __future__ import print_function

from operator import itemgetter

N, M = map(int, raw_input().strip().split(' '))

arr = []

for _ in range(0, N):
    arr.append(map(int, raw_input().strip().split(' ')))

K = int(raw_input())

for l in sorted(arr, key=itemgetter(K), reverse=False):
    for e in l:
        print(e, end=' ')
    print('\n', end='')
