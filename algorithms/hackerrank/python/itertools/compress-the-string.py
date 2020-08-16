import itertools

print ' '.join('('+str(len(list(e[1])))+', '+str(e[0])+')' for e in itertools.groupby(raw_input().strip()))
