class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<Integer>(Arrays.asList(0));
        }

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            List<Integer> root1 = graph.get(edge[0]);
            root1.add(edge[1]);

            List<Integer> root2 = graph.get(edge[1]);
            root2.add(edge[0]);

            inDegree.put(edge[0], inDegree.get(edge[0]) + 1);
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }

        Queue<Integer> leaves = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 1) {
                leaves.add(entry.getKey());
            }
        }

        int totalNodes = n;

        while (totalNodes > 2) {
            int size = leaves.size();
            totalNodes -= size;
            for (int i = 0; i < size; i++) {
                Integer root = leaves.poll();
                for (Integer child : graph.get(root)) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 1) {
                        leaves.offer(child);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        result.addAll(leaves);

        return result;
    }
}
