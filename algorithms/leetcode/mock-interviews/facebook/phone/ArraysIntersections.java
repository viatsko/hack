class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> used = new HashSet<>();
        
        for (int num : nums1) {
            used.add(num);
        }
        
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (used.contains(num)) {
                resultSet.add(num);
            }
        }
        
        int[] result = new int[resultSet.size()];
        
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        
        return result;
    }
}
