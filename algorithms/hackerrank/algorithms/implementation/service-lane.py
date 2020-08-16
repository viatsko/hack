n, t = map(int, raw_input().strip().split(' '))
width = map(int, raw_input().strip().split(' '))
for _ in range(0, t):
    i, j = map(int, raw_input().strip().split(' '))
    print min(width[i:j + 1])
