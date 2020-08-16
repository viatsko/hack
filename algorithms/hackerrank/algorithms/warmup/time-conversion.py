time = raw_input().strip()
[hours, minutes, seconds] = time.split(':')
hours = int(hours)
if seconds[2:] == 'PM' and hours != 12:
    hours += 12
elif seconds[2:] == 'AM' and hours == 12:
    hours = 0
hours = format(hours, '02')
seconds = seconds[:2]
print ":".join([hours, minutes, seconds])
