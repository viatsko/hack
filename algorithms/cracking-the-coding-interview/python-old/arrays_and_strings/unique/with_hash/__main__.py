#!/usr/bin/env python3


def is_unique(inpstr):
    letters = {}

    for i in range(len(inpstr)):
        if inpstr[i] in letters:
            return False

        letters[inpstr[i]] = True

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
