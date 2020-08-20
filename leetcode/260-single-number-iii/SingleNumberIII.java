public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int mask = xor & (-xor);

        int[] result = new int[]{0, 0};

        for (int num : nums) {
            if ((num & mask) == 0) {
                result[1] ^= num;
            } else {
                result[0] ^= num;
            }
        }

        return result;
    }
}
