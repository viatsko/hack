class Solution {
    /*
        [10, 0, 0, 0, 0, 0, 0, 0]
        [9, 0, 0, 0, 0, 0, 0, 0]
        [2, 0, 0, 0, 0, 0, 0, 0]
        [2, 5, 0, 0, 0, 0, 0, 0]
        [2, 3, 0, 0, 0, 0, 0, 0]
        [2, 3, 7, 0, 0, 0, 0, 0]
        [2, 3, 7, 101, 0, 0, 0, 0]
        [2, 3, 7, 18, 0, 0, 0, 0]
    */
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        
        if (N == 0) {
            return 0;
        }
        
        int[] dp = new int[N];
        
        int answer = 0;
        
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, answer, num);
            if (index < 0) index = - (index + 1);
            dp[index] = num;
            if (index == answer) answer++;
        }
        
        return answer;
    }
}
