class Solution {
    int[][] directions = new int[][]{
        {  1,   0 },
        { -1,   0 },
        {  0,   1 },
        {  0,  -1 }
    };
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new LinkedList<>();
        
        int n = matrix.length;
        
        if (n == 0) {
            return result;
        }
        
        int m = matrix[0].length;
        
        if (m == 0) {
            return result;
        }
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            pacificQueue.offer(new int[]{ i, 0 });
            atlantic[i][m - 1] = true;
            atlanticQueue.offer(new int[]{ i, m - 1 });
        }
        
        for (int i = 0; i < m; i++) {
            pacific[0][i] = true;
            pacificQueue.offer(new int[]{ 0, i });
            atlantic[n - 1][i] = true;
            atlanticQueue.offer(new int[]{ n - 1, i });
        }
        
        bfs(pacificQueue, matrix, n, m, pacific);
        bfs(atlanticQueue, matrix, n, m, atlantic);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void bfs(Queue<int[]> q, int[][] matrix, int n, int m, boolean[][] visited) {
        while (!q.isEmpty()) {
            int[] current = q.poll();
            
            for (int i = 0; i < directions.length; i++) {
                int[] next = new int[]{
                    current[0] + directions[i][0],
                    current[1] + directions[i][1]
                };
                
                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || visited[next[0]][next[1]] || matrix[next[0]][next[1]] < matrix[current[0]][current[1]]) {
                    continue;
                }
                
                visited[next[0]][next[1]] = true;
                
                q.add(next);
            }
        }
    }
}