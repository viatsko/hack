s = raw_input().split(' ')

for i in range(0, len(s)):
    if len(s[i]) > 0:
        s[i] = list(s[i])
        s[i][0] = s[i][0].upper()
        s[i] = ''.join(s[i])

print ' '.join(s)
