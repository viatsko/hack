public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // in one of the testcases, it's Integer.MIN_VALUE, so have to use boxed :(
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer num : nums) {
            // numbers might be non-unique [2,2,3,1]
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) {
                continue;
            }

            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        // check testcase [1,2]
        return max3 != null ? max3 : max1;
    }
}
