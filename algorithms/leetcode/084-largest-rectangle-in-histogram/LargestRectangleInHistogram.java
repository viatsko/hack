class Solution {
  public int largestRectangleArea(int[] nums) {
    Stack<Integer> positions = new Stack<>();
    Stack<Integer> heights = new Stack<>();

    int max = 0;


    for (int i = 0; i < nums.length; i++) {
      if (heights.empty()) {
        heights.push(nums[i]);
        positions.push(i);
      } else if (nums[i] > heights.peek()) {
        heights.push(nums[i]);
        positions.push(i);
      } else if (nums[i] < heights.peek()) {
        int position = 0;

        while (!heights.empty() && heights.peek() > nums[i]) {
          int height = heights.pop();
          position = positions.pop();
          int size = height * (i - position);
          max = Math.max(max, size);
        }

        heights.push(nums[i]);
        positions.push(position);
      }
    }

    while (!heights.empty()) {
      int size = heights.pop() * (nums.length - positions.pop());
      max = Math.max(max, size);
    }

    return max;
  }
}
