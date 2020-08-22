n = int(raw_input())

A = set(map(int, raw_input().strip().split(' ')))
N = int(raw_input())

for i in range(0, N):
    command = raw_input().strip().split(' ')
    S = set(map(int, raw_input().strip().split(' ')))

    if command[0] == 'intersection_update':
        A.intersection_update(S)
    elif command[0] == 'update':
        A.update(S)
    elif command[0] == 'symmetric_difference_update':
        A.symmetric_difference_update(S)
    elif command[0] == 'difference_update':
        A.difference_update(S)

print sum(A)
