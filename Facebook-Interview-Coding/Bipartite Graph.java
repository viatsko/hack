Bipartite Graph
// http://www.geeksforgeeks.org/bipartite-graph/


class Bipartite {
    final static int V = 4; // # of Vertices
 
    public boolean isBipartite(int G[][], int src) {
        //  The value 1 is used to indicate first color is assigned and value 0 indicates second color is assigned.
        int colorArr[] = new int[V];
        Arrays.fill(colorArr, -1);
        colorArr[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) 
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.add(v);
                } else if (G[u][v] == 1 && colorArr[v] == colorArr[u])    return false;
        }
        return true;
    }
}

