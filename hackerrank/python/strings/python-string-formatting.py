n = int(raw_input())

def dec_to_bin(x):
    return int(bin(x)[2:])

def dec_to_oct(x):
    return oct(x)[1:]

def dec_to_hex(x):
    return hex(x)[2:]

n_bin = dec_to_bin(n)
l = len(str(n_bin))

for x in range(1, n + 1):
    print str(x).rjust(l, ' ') + ' ' + str(dec_to_oct(x)).rjust(l, ' ') + ' ' + str(dec_to_hex(x)).upper().rjust(l, ' ') + ' ' + str(dec_to_bin(x)).rjust(l, ' ')
