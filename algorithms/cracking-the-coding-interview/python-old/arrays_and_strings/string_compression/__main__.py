#!/usr/bin/env python3


def compress(inpstr):
    curchar = inpstr[0]
    curlen = 1

    res = ''

    for c in inpstr[1:]:
        if curchar == c:
            curlen += 1
        else:
            res += curchar + str(curlen)
            curchar = c
            curlen = 1

    res += curchar + str(curlen)

    return res if len(res) < len(inpstr) else inpstr


def main():
    print('Enter a string for compression:')
    inpstr = input()

    print(compress(inpstr))


if __name__ == '__main__':
    main()
