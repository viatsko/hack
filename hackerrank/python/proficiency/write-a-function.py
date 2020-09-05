def is_leap(year):
    leap = False

    if year % 4 == 0:
        if year % 100 == 0 and year % 400 != 0:
            return False
        return True

    return leap

year = int(input())
