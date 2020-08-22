import math

d = int(raw_input())

b = int(raw_input())

a = math.hypot(d, b) / 2

print str(int(round(math.acos((a * a + b * b - a * a) / (2 * a * b)) * 180 / math.pi))) + '°'
