class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    int[] result = new int[n];

    Stack<Integer> stack = new Stack<>();

    int prevTimestamp = 0;

    for (String log : logs) {
      String[] params = log.split(":");

      int functionId = Integer.parseInt(params[0]);
      int timestamp = Integer.parseInt(params[2]);

      if (params[1].equals("start")) {
        // start
        if (!stack.empty()) {
          result[stack.peek()] += timestamp - prevTimestamp;
        }

        stack.push(functionId);

        prevTimestamp = timestamp;
      } else {
        // end
        stack.pop();

        result[functionId] += timestamp - prevTimestamp + 1;

        prevTimestamp = timestamp + 1;
      }
    }

    return result;
  }
}
