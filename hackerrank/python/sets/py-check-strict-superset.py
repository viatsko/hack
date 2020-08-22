A = set(map(int, raw_input().strip().split(' ')))
N = int(raw_input())

print not any(not set(map(int, raw_input().strip().split(' '))) < A for _ in range(N))
