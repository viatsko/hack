#!/usr/bin/env python3


def check_permutation_reversed(inpstr, inpstr2):
    return inpstr == ''.join(reversed(inpstr2))


def main():
    print('Enter first string:')

    inpstr = input()

    print('Enter second string:')

    inpstr2 = input()

    if check_permutation_reversed(inpstr, inpstr2):
        print('Permutation!')
    else:
        print('Not permutation!')


if __name__ == '__main__':
    main()
