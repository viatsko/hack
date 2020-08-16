string = list(raw_input())

# Write the code to find the required palindrome and then assign the variable 'found' a value of True or False

letters = {}

for s in string:
    if s in letters:
        letters[s] += 1
    else:
        letters[s] = 1

neg = 0
for i in letters:
    if letters[i] % 2 != 0:
        neg += 1

if neg > 1:
    print("NO")
else:
    print("YES")
