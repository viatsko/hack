class Solution {
    class DisjointSet {
        public int segments;
        int[] edges;
        int[] rank;
        
        public DisjointSet(int size) {
            edges = new int[size];
            Arrays.fill(edges, -1);
            rank = new int[size];
            segments = size;
        }
        
        public boolean union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            
            if (root1 == root2) {
                return false;
            }
            
            if (rank[root2] > rank[root1]) {
                edges[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                edges[root2] = root1;
            } else {
                edges[root1] = root2;
                rank[root1]++;
            }
            
            segments--;
            return true;
        }
        
        public int find(int i) {
            if (edges[i] == -1) return i;
            if (edges[i] == i) return i;
            return edges[i] = find(edges[i]);
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        for (int[] edge : edges) {
            int i = set.find(edge[0]);
            int j = set.find(edge[1]);
            
            if (i == j) {
                return false;
            }
            
            set.union(i, j);
        }
        
        return set.segments == 1;
    }
}
