class Solution {
    private boolean areOverlap(int[] left, int[] right) {
        return Math.max(left[0], right[0]) <= Math.min(left[1], right[1]);
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        
        if (intervals.length == 0) {
            result[0] = newInterval;
            
            return result;
        } else if (newInterval[1] < intervals[0][0]) {
            result[0] = newInterval;
            
            for (int i = 0; i < intervals.length; i++) {
                result[i + 1] = intervals[i];
            }
            
            return result;
        } else if (newInterval[0] > intervals[intervals.length - 1][1]) {
            result[intervals.length] = newInterval;
            
            for (int i = 0; i < intervals.length; i++) {
                result[i] = intervals[i];
            }
            
            return result;
        } else {
            int resultIndex = 0;
            boolean isResized = false;
            boolean isMerged = false;

            for (int i = 0; i < intervals.length; i++) {
                if (i > 0 && newInterval[0] > intervals[i - 1][1] && newInterval[1] < intervals[i][0]) {
                    result[resultIndex++] = newInterval;
                    isResized = true;
                } else if(!isMerged && areOverlap(intervals[i], newInterval)) {
                    
                    intervals[i][0] = Math.min(newInterval[0], intervals[i][0]);
                    intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);
                    
                    int j = 1;
                    while ((i + j < intervals.length) && areOverlap(intervals[i + j], intervals[i])) {
                        intervals[i][0] = Math.min(intervals[i + j][0], intervals[i][0]);
                    intervals[i][1] = Math.max(intervals[i + j][1], intervals[i][1]);
                        j++;
                    }
                    
                    result[resultIndex++] = intervals[i];
                    isMerged = true;
                    
                    i += j - 1;
                    
                    continue;
                }
                
                result[resultIndex++] = intervals[i];
            }
            
            return Arrays.copyOfRange(result, 0, resultIndex);
        }
    }
}
