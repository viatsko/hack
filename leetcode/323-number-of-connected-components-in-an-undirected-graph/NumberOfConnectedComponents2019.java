class Solution {
    class DisjointSet {
        int capacity;
        int segments;
        
        int[] edges;
        int[] ranks;
        
        public DisjointSet(int capacity) {
            this.capacity = capacity;
            edges = new int[capacity];
            Arrays.fill(edges, -1);
            ranks = new int[capacity];
            segments = capacity;
        }
        
        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            
            if (root1 == root2) {
                return;
            }
            
            if (ranks[root1] > ranks[root2]) {
                edges[root2] = root1;
            } else if (ranks[root2] > ranks[root1]) {
                edges[root1] = root2;
            } else {
                edges[root1] = root2;
                ranks[root1]++;
            }
            
            segments--;
        }
        
        public int find(int i) {
            if (edges[i] == -1)
                return edges[i] = i;
            if (edges[i] == i)
                return edges[i];
            return edges[i] = find(edges[i]);
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        for (int[] edge: edges) {
            set.union(edge[0], edge[1]);
        }
        return set.segments;
    }
}
