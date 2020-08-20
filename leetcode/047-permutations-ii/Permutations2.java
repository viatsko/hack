class Solution {
    private void helper(int[] nums, boolean[] visited, int pos, int[] currentResult, List<List<Integer>> result) {
        if (pos == nums.length) {
            result.add(Arrays.stream(currentResult).boxed().collect(Collectors.toList()));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            
            visited[i] = true;
            
            currentResult[pos] = nums[i];
            
            helper(nums, visited, pos + 1, currentResult, result);
            
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new LinkedList<>();
        
        boolean[] visited = new boolean[nums.length];
        
        helper(nums, visited, 0, new int[nums.length], result);
        
        return result;
    }
}