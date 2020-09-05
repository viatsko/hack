m = int(raw_input())
m_set = set(map(int, raw_input().strip().split()))
n = int(raw_input())
n_set = set(map(int, raw_input().strip().split()))

sd_set = m_set ^ n_set
sd_list = list(sd_set)
sd_list.sort()

for x in sd_list:
    print x
