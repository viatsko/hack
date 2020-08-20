#!/usr/bin/env python3


def check_permutation(inpstr, inpstr2):
    if len(inpstr) != len(inpstr2):
        return False

    a = sorted(inpstr)
    b = sorted(inpstr2)

    for i in range(len(a)):
        if a[i] != b[i]:
            return False

    return True


def main():
    print('Enter first string:')

    inpstr = input()

    print('Enter second string:')

    inpstr2 = input()

    if check_permutation(inpstr, inpstr2):
        print('Permutation!')
    else:
        print('Not permutation!')


if __name__ == '__main__':
    main()
