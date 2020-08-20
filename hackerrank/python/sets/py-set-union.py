n = int(raw_input())
n_set = set(map(int, raw_input().strip().split(' ')))

b = int(raw_input())
b_set = set(map(int, raw_input().strip().split(' ')))

print len(n_set | b_set)
