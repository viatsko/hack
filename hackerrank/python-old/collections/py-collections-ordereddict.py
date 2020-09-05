from collections import OrderedDict

d = OrderedDict()

for _ in range(int(raw_input())):
    a = raw_input().split()

    n = int(a.pop())
    k = ' '.join(a)

    if not (k in d):
        d[k] = n
    else:
        d[k] += n

for k in d.keys():
    print k + ' ' + str(d[k])
