class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        
        int answer = 0;
        int endMax = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= endMax) {
                endMax = intervals[i][1];
            } else {
                answer++;
            }
        }
        return answer;
    }
}