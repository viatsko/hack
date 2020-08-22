n = int(raw_input())
for _ in range(0, n):
    try:
        a, b = map(int, raw_input().strip().split(' '))
        print a//b
    except (ZeroDivisionError, ValueError) as e:
        print "Error Code:",e
