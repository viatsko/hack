class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> distanceFromOrigin(a) - distanceFromOrigin(b));
        
        return Arrays.copyOf(points, K);
    }
    
    private int distanceFromOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
