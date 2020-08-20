class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new LinkedList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2 /* -2 = j + k which take +1 each */; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    k--; j++;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return triplets;
    }
}
