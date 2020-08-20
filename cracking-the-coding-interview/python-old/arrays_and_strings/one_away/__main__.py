#!/usr/bin/env python3


def is_one_away(inpstr, inpstr2):
    diffs = 0

    equal_lengths = False

    if len(inpstr) >= len(inpstr2):
        l, s = (inpstr, inpstr2)

        if len(inpstr) == len(inpstr2):
            equal_lengths = True
    elif len(inpstr) < len(inpstr2):
        l, s = (inpstr2, inpstr)

    for i in range(len(s)):
        if s[i - (diffs if not equal_lengths else 0)] != l[i]:
            diffs += 1

            if diffs > 1:
                return False

    return True



def main():
    print('Enter a string:')

    inpstr = input()

    print('Enter a second string:')

    inpstr2 = input()

    if is_one_away(inpstr, inpstr2):
        print('One away!')
    else:
        print('Not one away!')


if __name__ == '__main__':
    main()
