N = int(raw_input())
w = 4 * N - 3

alpha_arr = []
a_ord = ord('a')
for x in range(0, N):
    alpha_arr.append(chr(a_ord))
    a_ord += 1

for i in xrange(1, N):
    flipped_arr = alpha_arr[-i:]
    flipped_arr.reverse()
    flipped_arr.pop()
    print '-'.join(flipped_arr + alpha_arr[-i:]).center(w, '-')
flipped_arr = alpha_arr[:]
flipped_arr.reverse()
flipped_arr.pop()
print '-'.join(flipped_arr + alpha_arr).center(w, '-')
for i in xrange(N - 1, 0, -1):
    flipped_arr = alpha_arr[-i:]
    flipped_arr.reverse()
    flipped_arr.pop()
    print '-'.join(flipped_arr + alpha_arr[-i:]).center(w, '-')
