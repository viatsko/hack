def find_num(total):
    for five_cnt in range(total, -1, -1):
        if five_cnt % 3 == 0:
            three_cnt = total - five_cnt
            if three_cnt % 5 == 0:
                return '5' * five_cnt + '3' * three_cnt
    return '-1'

t = int(raw_input())
for _ in range(0, t):
    n = int(raw_input())
    print find_num(n)
