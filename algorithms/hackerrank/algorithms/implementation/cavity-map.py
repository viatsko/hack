n = int(raw_input())
x = []
res = []

for i in range(0, n):
    x.append(raw_input())

res.append(x[0])

for i in range(1, len(x) - 1):
    res.append(x[i][0])

    for a in range(1, len(x[i]) - 1):
        center = int(x[i][a])

        if center > int(x[i - 1][a]) and center > int(x[i][a + 1]) and center > int(x[i+1][a]) and center > int(x[i][a - 1]):
            res[i] += 'X'
        else:
            res[i] += x[i][a]

    res[i] += x[i][-1]

if n != 1:
    res.append(x[-1])

for i in range(len(res)):
    print res[i]
