#!/usr/bin/env python3

qs_shift = 0
is_shift = 0


def quick_sort(arr, lo, hi):
    if lo < hi:
        p = partition(arr, lo, hi)
        quick_sort(arr, lo, p - 1)
        quick_sort(arr, p + 1, hi)


def partition(arr, lo, hi):
    global qs_shift

    pivot = arr[hi]
    i = lo
    for j in range(lo, hi):
        if arr[j] <= pivot:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            qs_shift += 1

    arr[i], arr[hi] = arr[hi], arr[i]

    qs_shift += 1

    return i


def insertion_sort(l):
    global is_shift

    for i in range(1, len(l)):
        j = i - 1
        key = l[i]
        while (j >= 0) and (l[j] > key):
            l[j + 1] = l[j]
            j -= 1
            is_shift += 1
        l[j + 1] = key


if __name__ == "__main__":
    n = int(input())
    arr = list(map(int, input().split()))

    qs_arr = arr[:]

    quick_sort(qs_arr, 0, len(qs_arr) - 1)
    insertion_sort(arr)

    print(is_shift - qs_shift)
