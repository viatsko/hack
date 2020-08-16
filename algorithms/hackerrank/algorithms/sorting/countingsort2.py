#!/usr/bin/env python3

n = int(input())
arr = list(map(int, input().split()))

numbers = [0] * 100

for number in arr:
    numbers[number] += 1

for i in range(100):
    if numbers[i] > 0:
        print(numbers[i] * (str(i) + " "), end="")
