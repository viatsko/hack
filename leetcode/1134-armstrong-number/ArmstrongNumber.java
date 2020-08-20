class Solution {
    public boolean isArmstrong(int N) {
        int[] counts = new int[10];
        int total_count = 0;
        int n = N; // we need to keep an input number copy for further comparison
        
        while (n > 0) {
            int digit = n % 10;
            counts[digit]++;
            total_count++;
            n /= 10;
        }
        
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (counts[i] == 0) {
                continue;
            }
            
            sum += Math.pow(i, total_count) * counts[i];
        }
        
        return sum == N;
    }
}
