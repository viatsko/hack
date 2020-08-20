class Solution {
    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int current) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = current; i < candidates.length; i++) {
            if (i > current && candidates[i] == candidates[i - 1]) continue;
            
            path.add(candidates[i]);
            
            helper(candidates, target - candidates[i], result, path, i + 1);
            
            path.remove(path.size() - 1);
        }
    }
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        
        Arrays.sort(candidates);
        
        // = [1, 1, 2, 5, 6, 7, 10]
        
        helper(candidates, target, result, new ArrayList<>(), 0);

        return result;
    }
}
