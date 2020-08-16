n = int(raw_input())
arr = map(int, raw_input().strip().split(' '))

print sorted(set(arr))[-2]
