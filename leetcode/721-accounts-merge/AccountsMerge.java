class Solution {
  int[] id;
  int count = 0;

  private int find(int i) {
    while (i != id[i] && id[i] != -1) {
      i = id[i];
    }

    return i;
  }

  private void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);

    id[rootP] = rootQ;
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int N = accounts.size();

    id = new int[N];
    Arrays.fill(id, -1);

    Map<String, Integer> emailToId = new HashMap<>();

    for (int i = 0; i < N; i++) {
      List<String> account = accounts.get(i);

      for (int j = 1; j < account.size(); j++) {
        String email = account.get(j);

        Integer idx = emailToId.get(email);
        if (idx != null) {
          union(idx, i); // we are merging existing email which is "root" to this index
        } else {
          emailToId.put(email, i);
        }
      }
    }

    Map<Integer, Set<String>> idToEmails = new HashMap<>();

    for (int i = 0; i < N; i++) {
      int root = find(i);

      if (!idToEmails.containsKey(root)) {
        idToEmails.put(root, new TreeSet<>());
      }

      List<String> account = accounts.get(i);

      Set<String> emailsSet = idToEmails.get(root);

      for (int j = 1; j < account.size(); j++) {
        emailsSet.add(account.get(j));
      }
    }

    List<List<String>> results = new LinkedList<>();

    for (Map.Entry<Integer, Set<String>> entry : idToEmails.entrySet()) {
      List<String> result = new LinkedList<>();
      result.add(accounts.get(entry.getKey()).get(0));
      result.addAll(entry.getValue());
      results.add(result);
    }

    return results;
  }
}
