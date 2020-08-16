#!/usr/bin/env python3


def check_permutation(inpstr, inpstr2):
    if len(inpstr) != len(inpstr2):
        return False

    a = {}

    b = {}

    for i in range(len(inpstr)):
        if inpstr[i] in a:
            a[inpstr[i]] += 1
        else:
            a[inpstr[i]] = 1

    for i in range(len(inpstr2)):
        if inpstr2[i] not in a:
            return False

        if inpstr2[i] in b:
            b[inpstr2[i]] += 1
        else:
            b[inpstr2[i]] = 1

    if len(a) != len(b):
        return False

    for i in a:
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
