#!/bin/python

import sys

h = int(raw_input().strip())
m = int(raw_input().strip())

hours = [
    None,
    'one',
    'two',
    'three',
    'four',
    'five',
    'six',
    'seven',
    'eight',
    'nine',
    'ten',
    'eleven',
    'twelve'
]
minutes = [
    None,
    'one',
    'two',
    'three',
    'four',
    'five',
    'six',
    'seven',
    'eight',
    'nine',
    'ten',
    'eleven',
    'twelve',
    'thirteen',
    'fourteen',
    'quarter',
    'sixteen',
    'seventeen',
    'eighteen',
    'nineteen',
    'twenty',
    'twenty one',
    'twenty two',
    'twenty three',
    'twenty four',
    'twenty five',
    'twenty six',
    'twenty seven',
    'twenty eight',
    'twenty nine',
    'half'
]

if m == 0:
    print hours[h] + ' o\' clock'
elif m <= 30:
    print minutes[m] + ((' minute' if m == 1 else ' minutes') if m % 15 != 0 else '') + ' past ' + hours[h]
elif m > 30:
    print minutes[60 - m] + ((' minute' if m == 59 else ' minutes') if m % 15 != 0 else '') + ' to ' + hours[h + 1 if h != 12 else 1]
