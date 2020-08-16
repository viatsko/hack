l = list(raw_input())
d = {}

for let in l:
    if let.isalpha():
        d[let.lower()] = True
if len(d) == 26:
    print 'pangram'
else:
    print 'not pangram'
