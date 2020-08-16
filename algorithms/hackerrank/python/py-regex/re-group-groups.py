import re

m = re.search(r'([A-Za-z0-9])\1+', raw_input().strip())

if m is None:
    print '-1'
else:
    print m.group(0)[0]
