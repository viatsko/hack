public class MaximumProductOfThreeNumbers {
    // Based on LeetCode 414
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        // these are now unboxed
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        // we need only 2 mins, as -1 * -1 = positive, while three nums are giving neg
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        /*
         * max1 is always biggest,
         * so we use it for multiplication of two biggest negatives,
         * otherwise max is just 3 max numbers multiplied
         */
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
