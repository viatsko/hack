#!/usr/bin/env python3


def is_substring(str1, str2):
    return str1.find(str2) > 0


def is_string_rotation(inpstr, inpstr2):
    if len(inpstr) != len(inpstr2):
        return False

    s = inpstr + inpstr

    if is_substring(s, inpstr2):
        return True

    return False


def main():
    print('Enter a string:')

    inpstr = input()

    print('Enter a second string:')

    inpstr2 = input()

    if is_string_rotation(inpstr, inpstr2):
        print('Rotation')
    else:
        print('Not rotation')


if __name__ == '__main__':
    main()
