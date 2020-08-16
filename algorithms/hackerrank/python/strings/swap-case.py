s = raw_input()

list_s = list(s)

for i in range(0, len(list_s)):
    if list_s[i].islower():
        list_s[i] = list_s[i].upper()
    elif list_s[i].isupper():
        list_s[i] = list_s[i].lower()

print ''.join(list_s)
