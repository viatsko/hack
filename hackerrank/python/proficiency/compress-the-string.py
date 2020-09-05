# Enter your code here. Read input from STDIN. Print output to STDOUT
import itertools
res = []
for k, g in itertools.groupby(input().strip()):
    res.append((len(list(g)), int(k)))
print(' '.join(map(str, res)))
