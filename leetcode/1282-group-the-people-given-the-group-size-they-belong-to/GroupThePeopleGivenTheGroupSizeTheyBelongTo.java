class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, List<List<Integer>>> groups = new HashMap<>();

    for (int i = 0; i < groupSizes.length; i++) {
      if (!groups.containsKey(groupSizes[i])) {
        groups.put(groupSizes[i], new ArrayList<>());
        groups.get(groupSizes[i]).add(new ArrayList<>());
      }

      List<List<Integer>> bucketGroups = groups.get(groupSizes[i]);
      List<Integer> bucketGroup = groups.get(groupSizes[i]).get(bucketGroups.size() - 1);

      if (bucketGroup.size() == groupSizes[i]) {
        bucketGroup = new ArrayList<>();
        bucketGroups.add(bucketGroup);
      }

      bucketGroup.add(i);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (List<List<Integer>> group : groups.values()) {
      result.addAll(group);
    }

    return result;
  }
}
