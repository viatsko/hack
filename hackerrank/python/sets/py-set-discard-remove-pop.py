n = int(raw_input())
s = set(map(int, raw_input().split()))
i = int(raw_input())

for _ in range(0, i):
    command = raw_input().strip().split(' ')
    if command[0] == 'pop':
        s.pop()
    elif command[0] == 'remove':
        s.remove(int(command[1]))
    elif command[0] == 'discard':
        s.discard(int(command[1]))

print sum(s)
