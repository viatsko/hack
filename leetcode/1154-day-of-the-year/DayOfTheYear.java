class Solution {
    private final int[] DAYS_IN_MONTHS = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    private boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }
    
    public int dayOfYear(String date) {
        int daysCount = 0;
        
        String[] dateParts = date.split("-");
        Integer year = Integer.parseInt(dateParts[0], 10);
        boolean isCurrentYearLeap = isLeapYear(year);
        Integer month = Integer.parseInt(dateParts[1], 10);
        month--;
        Integer day = Integer.parseInt(dateParts[2], 10);
        
        while (month > 0) {
            daysCount += month == 2 && isCurrentYearLeap ? 29 : DAYS_IN_MONTHS[month];
            month--;
        }
        
        daysCount += day;
        
        return daysCount;
    }
}
