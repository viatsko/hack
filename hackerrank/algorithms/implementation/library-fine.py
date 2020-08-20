#!/bin/python

import sys
from datetime import date


d1,m1,y1 = raw_input().strip().split(' ')
d1,m1,y1 = [int(d1),int(m1),int(y1)]
d2,m2,y2 = raw_input().strip().split(' ')
d2,m2,y2 = [int(d2),int(m2),int(y2)]

actual_date = date(y1, m1, d1)
expected_date = date(y2, m2, d2)

if actual_date.year > expected_date.year:
    print 10000
elif actual_date.year < expected_date.year:
    print 0
elif actual_date.month > expected_date.month:
    print (actual_date.month - expected_date.month) * 500
elif actual_date.month < expected_date.month:
    print 0
elif actual_date.day > expected_date.day:
    print (actual_date.day - expected_date.day) * 15
else:
    print 0
