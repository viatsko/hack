x, k = map(int, raw_input().strip().split(' '))

e = raw_input()
print int(eval(e.replace('x', str(x)))) == k
