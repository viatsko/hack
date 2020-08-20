public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }

        return Math.max(even, odd);
    }
}
