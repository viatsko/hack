#!/usr/bin/env python3


def urlify(inpstr, length):
    i = 0
    res = ''

    for c in inpstr:
        i += 1

        if i > length:
            return res
        elif c == ' ':
            res += '%20'
        else:
            res += c

    return res


def main():
    print('Enter string to urlify:')

    inpstr = input()

    print('Enter string length:')

    length = int(input())

    print(urlify(inpstr, length))


if __name__ == '__main__':
    main()
