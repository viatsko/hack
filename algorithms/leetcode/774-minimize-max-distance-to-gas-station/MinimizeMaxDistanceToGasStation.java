class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double left = 0;
        double right = 1e9;
        
        while (right - left > 1e-6) {
            double mid = (left + right) / 2.0;
            
            if (!isPossible(stations, K, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private boolean isPossible(int[] stations, int K, double dist) {
        for (int i = 1; i < stations.length; i++) {
            K -= (int) ((stations[i] - stations[i - 1]) / dist);
        }
        
        return K >= 0;
    }
}
