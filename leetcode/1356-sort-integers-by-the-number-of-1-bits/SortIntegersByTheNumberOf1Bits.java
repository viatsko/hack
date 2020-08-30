class Solution {
  public int[] sortByBits(int[] inputArray) {
    Integer[] arr = Arrays.stream(inputArray).boxed().toArray(Integer[]::new);

    Arrays.sort(arr, (a, b) -> {
      int ab = Integer.bitCount(a);
      int bb = Integer.bitCount(b);

      if (ab == bb) {
        return a - b;
      }

      return ab - bb;
    });

    return Arrays.stream(arr).mapToInt(r -> r).toArray();
  }
}
