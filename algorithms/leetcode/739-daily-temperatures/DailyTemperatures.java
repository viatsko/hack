class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
      int N = temperatures.length;

      int[] result = new int[N];

      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < N; i++) {
          while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
              int idx = stack.pop();
              result[idx] = i - idx;
          }

          stack.push(i);
      }

      return result;
  }
}
