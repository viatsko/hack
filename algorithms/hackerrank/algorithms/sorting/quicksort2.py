#!/usr/bin/env python3

# The MIT License (MIT)
# =====================
#
# Copyright © 2016 Valerii Iatsko
#
# Permission is hereby granted, free of charge, to any person
# obtaining a copy of this software and associated documentation
# files (the “Software”), to deal in the Software without
# restriction, including without limitation the rights to use,
# copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the
# Software is furnished to do so, subject to the following
# conditions:
#
# The above copyright notice and this permission notice shall be
# included in all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
# OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
# NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
# HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
# WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
# FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
# OTHER DEALINGS IN THE SOFTWARE.


def quick_sort(*ar):
    equal, *arr = ar

    left, right = [], []

    for i in arr:
        if i < equal:
            left.append(i)
        else:
            right.append(i)

    if len(left) > 1:
        left = quick_sort(*left)

        print(*left)

    if len(right) > 1:
        right = quick_sort(*right)

        print(*right)

    return left + [equal] + right

n = int(input())
equal, *arr = map(int, input().split())
print(*quick_sort(equal, *arr))
