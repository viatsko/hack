from __future__ import print_function

n = int(raw_input().strip())

for stage in range(1, n + 1):
    for ch in range(0, n):
        if ch < n - stage:
            print(' ', end='')
        else:
            print('#', end='')
    print()
