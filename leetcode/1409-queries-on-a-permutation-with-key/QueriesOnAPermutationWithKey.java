class Solution {
  public int[] processQueries(int[] queries, int m) {
    List<Integer> permutation = IntStream.rangeClosed(1, m).boxed().collect(Collectors.toList());

    int[] result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int index = permutation.indexOf(queries[i]);
      result[i] = index;
      permutation.remove(index);
      permutation.add(0, queries[i]);
    }

    return result;
  }
}
