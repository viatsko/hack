import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums1.length;
        for (int aNums1 : nums1) {
            map.compute(aNums1, (key, value) -> value == null ? 1 : value + 1);
        }

        int m = nums2.length;
        for (int aNums2 : nums2) {
            Integer count = map.get(aNums2);

            if (count == null || count == 0) {
                continue;
            }

            map.put(aNums2, count - 1);

            intersection.add(aNums2);
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
