n = int(raw_input().strip())
s = raw_input().strip()
k = int(raw_input().strip())

l = list(s)

for x in range(0, len(l)):
    if l[x].isalpha():
        a = ord('A') if l[x].isupper() else ord('a')

        l[x] = chr(a + (ord(l[x]) - a + k) % 26)

print ''.join(l)
