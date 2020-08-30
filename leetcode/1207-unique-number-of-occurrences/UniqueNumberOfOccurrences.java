class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    Map <Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int count = map.getOrDefault(arr[i], 0);
      map.put(arr[i], count + 1);
    }

    Set<Integer> set = new HashSet<>(map.values());

    return set.size() == map.values().size();
  }
}
