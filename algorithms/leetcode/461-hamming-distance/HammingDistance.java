class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x > 0 || y > 0) {
            result += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return result;
    }
}
