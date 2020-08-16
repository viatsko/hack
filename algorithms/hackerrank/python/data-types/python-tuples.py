n = int(raw_input())
arr = map(int, raw_input().strip().split(' '))

print hash(tuple(arr))
