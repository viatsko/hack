K = int(raw_input())
S = map(int, raw_input().split())
s = set(S)

print (sum(s) * K - sum(S)) / (K - 1)
