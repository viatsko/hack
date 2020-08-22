k = int(raw_input())

d = {}

for _ in range(0, k):
    arr = raw_input().strip().split(' ')
    name = arr[0]
    marks = map(float, arr[1:])

    d[name] = marks

name = raw_input()
print "{0:.2f}".format(sum(d[name]) / float(len(d[name])))
