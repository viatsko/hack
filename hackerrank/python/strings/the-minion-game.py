r = [0, 0]
s = raw_input().strip()
for i, c in enumerate(s):
    r[c in 'AEIOU'] += len(s) - i

if r[0] > r[1]:
    print 'Stuart {0}'.format(r[0])
elif r[0] < r[1]:
    print 'Kevin {0}'.format(r[1])
else:
    print 'Draw'
