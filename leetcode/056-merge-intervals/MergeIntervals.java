class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList<>();
        
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            
            return a[0] - b[0];
        });
        
        for (int i = 0; i < intervals.length; i++) {
            int[] newInterval = new int[]{ intervals[i][0], intervals[i][1] };
            
            while ((i < intervals.length - 1) && intervals[i + 1][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i + 1][1]);
                i++;
            }
            
            result.add(newInterval);
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}