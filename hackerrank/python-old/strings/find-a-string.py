s = raw_input()
ss = raw_input()

counted = 0

for i in range(0, len(s)):
    if s[i:i+len(ss)] == ss:
        counted += 1

print counted
