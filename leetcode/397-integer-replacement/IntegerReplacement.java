class Solution {
    public int integerReplacement(int n) {
        int answer = 0;
        while (n != 1) {
            /* if even - it's always better to shift right */
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                n--;
            } else {
                n++;
            }
            
            answer++;
        }
        return answer;
    }
}
