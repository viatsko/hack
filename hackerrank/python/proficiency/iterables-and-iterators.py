import itertools

N = input()
letters = input().split()
K = int(input())

combs = itertools.combinations(letters, K)

g = list(combs)

print('{:.3f}'.format(len(list(filter(lambda c: 'a' in c, g)))/len(g)))
