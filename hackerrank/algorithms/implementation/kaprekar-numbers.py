def is_kaprekar(n):
    squared = str(n ** 2)
    mid = len(squared) - len(str(n))
    a = int(squared[mid:])
    b = int(squared[:mid]) if len(squared) > 1 else 0
    return a + b == n

p = int(raw_input())
q = int(raw_input())

kaprekars = [str(x) for x in xrange(p, q + 1) if is_kaprekar(x)]

print ' '.join(kaprekars) if kaprekars else 'INVALID RANGE'
