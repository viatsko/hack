class Solution {
  public int getKth(int lo, int hi, int k) {
    Integer[] nums = IntStream.rangeClosed(lo, hi).boxed().toArray(Integer[]::new);

    Arrays.sort(nums, (a, b) -> {
      int ap = power(a);
      int bp = power(b);

      if (ap == bp) {
        return a - b;
      }

      return ap - bp;
    });

    return nums[k - 1];
  }

  protected Map<Integer,Integer> memo = new HashMap<>();

  protected int power(int n) {
    if (n < 2) {
      return 0;
    }

    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    int result = 1 + (n % 2 == 0 ? power(n / 2) : power(3 * n + 1));

    memo.put(n, result);

    return result;
  }
}
