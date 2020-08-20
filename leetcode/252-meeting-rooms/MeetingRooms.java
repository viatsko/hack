class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int overlap = 0;
        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= maxEnd) {
                maxEnd = intervals[i][1];
            } else {
                overlap++;
            }
        }
        return overlap == 0;
    }
}