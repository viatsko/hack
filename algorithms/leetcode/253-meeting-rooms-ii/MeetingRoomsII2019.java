class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> currentMeetings = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        int maxRooms = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            while(!currentMeetings.isEmpty() && currentMeetings.peek() <= intervals[i][0]) {
                currentMeetings.poll();
            }
            
            currentMeetings.offer(intervals[i][1]);
            
            maxRooms = Math.max(currentMeetings.size(), maxRooms);
        }
        
        return maxRooms;
    }
}
