t = int(raw_input().strip())
for _ in range(0, t):
    n, c, m = map(int, raw_input().strip().split(' '))

    result = 0

    ch = n / c
    result += ch

    while True:
        wrapper = ch / m
        result += wrapper

        remain = ch % m
        ch = wrapper + remain

        if ch < m:
            break

    print result
