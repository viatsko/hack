#!/bin/python


def max_subarray(L):
    current_sum = 0
    current_index = -1
    best_sum = 0
    best_start_index = -1
    best_end_index = -1

    for i in xrange(len(L)):
        val = current_sum + L[i]

        if val > 0:
            if current_sum == 0:
                current_index = i
            current_sum = val
        else:
            current_sum = 0

        if current_sum > best_sum:
            best_sum = current_sum
            best_start_index = current_index
            best_end_index = i

    return L[best_start_index:best_end_index + 1]


def main():
    n = int(raw_input())
    for _ in range(0, n):
        k = int(raw_input())
        arr = map(int, raw_input().strip().split(' '))
        if all(i <= 0 for i in arr):
            print max(arr), max(arr)
        else:
            print sum(max_subarray(arr)), sum(x for x in arr if x > 0)


if __name__ == '__main__':
    main()
