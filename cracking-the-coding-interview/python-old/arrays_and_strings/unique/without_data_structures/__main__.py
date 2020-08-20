#!/usr/bin/env python3


def is_unique(inpstr):
    letters = 0

    for i in range(len(inpstr)):
        c = ord(inpstr[i])

        if letters & (1 << c) > 0:
            return False

        letters |= (1 << c)

    return True


def main():
    print('Enter a string:')

    inpstr = input()

    if is_unique(inpstr):
        print('All characters unique')
    else:
        print('Characters are not unique')


if __name__ == '__main__':
    main()
