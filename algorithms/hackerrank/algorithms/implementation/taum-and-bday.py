t = int(raw_input())
for _ in xrange(t):
    b, w = map(int, raw_input().split())
    x, y, z = map(int, raw_input().split())

    print min(b*x, b*(y+z)) + min(w*(x+z), w*y)
