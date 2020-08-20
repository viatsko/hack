public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int answer = 0;
        
        while (n != 0) {
            long y = n & ~(n - 1);
            n ^= y;
            answer++;
        }
        
        return answer;
    }
}
