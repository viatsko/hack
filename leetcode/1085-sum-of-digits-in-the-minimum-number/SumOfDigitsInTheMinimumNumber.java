class Solution {
    public int sumOfDigits(int[] A) {
        int n = Integer.MAX_VALUE;
        
        for (int a : A) {
            if (a < n) {
                n = a;
            }
        }
        
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        
        return s % 2 == 1 ? 0 : 1;
    }
}
