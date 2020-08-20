class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> trackingSet = new HashSet<>();
        
        for (int num : nums) {
            if (trackingSet.contains(num)) {
                return true;
            }
            trackingSet.add(num);
        }
        
        return false;
    }
}
