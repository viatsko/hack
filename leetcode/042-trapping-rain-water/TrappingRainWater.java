public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxL = 0;
        int maxR = 0;

        int result = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= maxL) {
                    maxL = height[l];
                } else {
                    result += maxL - height[l];
                }

                l++;
            } else {
                if (height[r] >= maxR) {
                    maxR = height[r];
                } else {
                    result += maxR - height[r];
                }

                r--;
            }
        }

        return result;
    }
}
