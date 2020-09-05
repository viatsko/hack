import re

for i in range(int(raw_input())):
    try:
        re.compile(raw_input().strip())
        print(True)
    except re.error:
        print(False)
