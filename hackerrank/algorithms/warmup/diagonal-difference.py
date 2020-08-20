n = int(raw_input().strip())
c = 0
f_d_total = 0
s_d_total = 0
for _ in xrange(n):
    a_temp = map(int, raw_input().strip().split(' '))
    f_d_total += a_temp[c]
    s_d_total += a_temp[0 - c - 1]
    c += 1

print abs(f_d_total - s_d_total)
