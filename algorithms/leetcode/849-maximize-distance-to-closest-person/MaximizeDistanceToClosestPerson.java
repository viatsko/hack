class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 0) {
            return 1;
        }
        
        int max = 0;

        // special case in the beginning
        int left = 0;
        while (seats[left] == 0) {
            max = Math.max(++left, max);
        }
        
        // special case in the end
        int right = seats.length - 1;
        while (seats[right] == 0) {
            max = Math.max(seats.length - right--, max);
        }
        
        int last = right;
        
        right = left + 1;
        
        while (right <= last) {
            if (seats[left] == 1 && seats[right] == 1) {
                max = Math.max(max, (right - left) / 2);
                left = right;
            }
            
            right++;
        }
        
        return max;
    }
}
