n = int(raw_input())

for _ in range(n):
    s = list(raw_input())

    l = len(s)

    equal = True

    for i in range(l - 1):
        if not (abs(ord(s[i]) - ord(s[i + 1])) == abs(ord(s[l - i - 1]) - ord(s[l - i - 2]))):
            equal = False

    if equal:
        print 'Funny'
    else:
        print 'Not Funny'
