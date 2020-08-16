class Solution {
    private int calculateDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    private int helper(int[][] workers, int[][] bikes, int sum, int pos, boolean[] visited) {
        if (pos == workers.length) {
            return sum;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            
            min = Math.min(min, helper(workers, bikes, sum + calculateDistance(workers[pos], bikes[i]), pos + 1, visited));
            
            visited[i] = false;
        }
        
        return min;
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visited = new boolean[bikes.length];
        
        return helper(workers, bikes, 0, 0, visited);
    }
}
