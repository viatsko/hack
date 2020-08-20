class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbersPositions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbersPositions.containsKey(target - nums[i])) {
                return new int[]{ numbersPositions.get(target - nums[i]), i };
            }
            
            numbersPositions.put(nums[i], i);
        }
        
        return new int[]{ -1, -1 };
    }
}
