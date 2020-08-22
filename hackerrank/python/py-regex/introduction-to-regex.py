import re

for _ in range(0, int(raw_input().strip())):
    print bool(re.match(r"^[+-]?\d*.\d+$", raw_input().strip()))
