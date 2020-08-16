pos = 0.0
neg = 0.0
zeros = 0.0

n = float(raw_input().strip())
arr = map(int, raw_input().strip().split(' '))

for x in arr:
    if x > 0:
        pos += 1 / n
    elif x < 0:
        neg += 1 / n
    else:
        zeros += 1 / n

print pos
print neg
print zeros
