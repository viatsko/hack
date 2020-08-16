class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        
        int answer = 0;
        
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            
            int count = 0;
            while (set.contains(num++))
                count++;
            
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
}
