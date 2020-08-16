class Solution {
  private boolean isLeapYear(int year) {
    return ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0));
  }

  public String dayOfTheWeek(int day, int month, int year) {
    String[] daysOfTheWeek = new String[]{
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };

    int[] monthDays = new int[]{
        31,
        28,
        31,
        30,
        31,
        30,
        31,
        31,
        30,
        31,
        30,
        31
    };

    int daysForward = 0;
    for (int i = 1971; i < year; i++) {
      if (isLeapYear(i)) {
        daysForward += 366;
      } else {
        daysForward += 365;
      }
    }

    daysForward += day;

    for (int i = 1; i < month; i++) {
      if (isLeapYear(year) && i == 2) {
        daysForward += 29;
      } else {
        daysForward += monthDays[i - 1];
      }
    }

    return daysOfTheWeek[(3 + daysForward) % 7];
  }
}
