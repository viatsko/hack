s = list(raw_input())
i, c = raw_input().strip().split(' ')
i = int(i)

s[i] = c

print ''.join(s)
