#!/usr/bin/env python3

from collections import Counter


def check_palindrome_permutation(inpstr):
    letters = Counter()

    for c in inpstr:
        c = c.lower()

        if c.isalpha():
            letters[c] += 1

    has_odd = False
    for c in letters:
        if letters[c] % 2 != 0:
            if has_odd:
                return False
            has_odd = True

    return True


def main():
    print('Enter a string:')

    inpstr = input()

    if check_palindrome_permutation(inpstr):
        print('Palindrome!')
    else:
        print('Not Palindrome!')


if __name__ == '__main__':
    main()
