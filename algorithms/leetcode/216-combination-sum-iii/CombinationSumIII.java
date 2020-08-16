class Solution {
    private void helper(List<List<Integer>> result, int k, int target, int curr, List<Integer> path) {
        int pathLen = path.size();
        if (pathLen == k) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            if (target < 0) {
                return;
            }
        }
        
        if (pathLen >= k) {
            return;
        }
        
        for (int i = curr; i<= 9; i++) {
            path.add(i);
            helper(result, k, target - i, i + 1, path);
            path.remove(pathLen);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        
        int[] path = new int[k];
        
        helper(result, k, n, 1, new ArrayList<>());
        
        return result;
    }
}
