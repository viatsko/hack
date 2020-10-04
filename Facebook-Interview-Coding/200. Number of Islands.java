200. Number of Islands
// https://leetcode.com/problems/number-of-islands/

Solution 1: DFS
Time: O(m * n)

public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)   return 0;
    int m = grid.length, n = grid[0].length, res = 0;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (grid[i][j] == '1') {
                DFSMarking(grid, i, j);
                res++;
            }
    return res;
}
public void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
        return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
    DFSMarking(grid, i - 1, j);
}

Solution 2: BFS 
public int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)   return 0;
    int m = grid.length, n = grid[0].length, res = 0;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (grid[i][j] == '1') {
                bfs(grid, i, j);
                res++;
            }
    return res;
}
private void bfs(char[][] grid, int i, int j) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{i, j});
    while (!q.isEmpty()) {
        int[] pos = q.poll();
        for (int[] d : dirs) {
            int x = pos[0] + d[0], y = pos[1] + d[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') 
                continue;
            grid[x][y] = '0';
            q.offer(new int[]{x, y});
        }
    }
}

Solution 3: Union - Find

public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0)   return 0;
    int m = grid.length, n = grid[0].length;
    UnionFind uf = new UnionFind(grid, m, n);
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) 
            if (grid[i][j] == '1') {
                int p = i * n + j, q;
                if (i > 0 && grid[i - 1][j] == '1') {
                    q = p - n;
                    uf.union(p, q);
                } 
                if (j > 0 && grid[i][j - 1] == '1') {
                    q = p - 1;
                    uf.union(p, q);
                }
                if (i < m - 1 && grid[i + 1][j] == '1') {
                    q = p + n;
                    uf.union(p, q);
                }
                if (j < n - 1 && grid[i][j + 1] == '1') {
                    q = p + 1;
                    uf.union(p, q);
                }
            }
    return uf.getCount();
}
class UnionFind{
    int[] lands;
    int count;
    public UnionFind(char[][] grid, int m, int n) {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1')  count++;
        lands = new int[m * n];
        for (int i = 0; i < m * n; i++) 
            lands[i] = -1;
    }
    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }
    public int find(int i) {
        if (lands[i] < 0)
            return i;
        else { //path compression
            lands[i] = find(lands[i]);
            return lands[i];
        }
    }
    public void union(int i, int j) {
        int root1 = find(i), root2 = find(j);
        if (root1 == root2) return;
        if (lands[root1] > lands[root2]) {
            lands[root2] += lands[root1];
            lands[root1] = root2;
        } else {
            lands[root1] += lands[root2];
            lands[root2] = root1;
        }
        count--;
    }
    public int getCount() {
        return count;
    }
}

1, 如果加上斜的也可以。dfs加四种情况
2, 不让改变原有的input，我就说那就建一个相同size的2d boolean array。grid复制给visit，改变visit，或者加参数boolean visited[][]
3, 转换为union find或者bfs，bfs解法：https://discuss.leetcode.com/topic/12230/c-bfs-solution-may-help-you





******变种1******
求largest size of islands
// dfs solution
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)    return 0;
    int m = grid.length, n = grid[0].length, max = 0;
    boolean[][] visited = new boolean[m][n];//O(1) space: directly modify the '1' to '2' to mark grid[i][j] visited
    for (int i = 0; i < m; i++) 
        for (int j = 0; j < n; j++) 
            if (grid[i][j] == '1' && !visited[i][j]) 
                max = Math.max(max, dfs(grid, visited, m, n, i, j));
    return max;
}
private int dfs(char[][] grid, boolean[][] visited, int m, int n, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1' || visited[i][j])    return 0; // important!
    visited[i][j] = true;
    return 1 + dfs(grid, visited, m, n, i + 1, j) + dfs(grid, visited, m, n, i - 1, j) 
            + dfs(grid, visited, m, n, i, j + 1) + dfs(grid, visited, m, n, i, j - 1);
}

// bfs solution
略


*****变种*****
求perimeter of given island，注意想明白island的周长到底指什么

// dfs solution
public int numIslands(char[][] grid, int i, int j) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)    return 0;
    int m = grid.length, n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')    return 0;
    boolean[][] visited = new boolean[m][n];//O(1) space: directly modify the '1' to '2' to mark grid[i][j] visited
    return dfs(grid, visited, m, n, i, j);
}
private int dfs(char[][] grid, boolean[][] visited, int m, int n, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') 
        return 1; // important
    if (visited[i][j])    return 0;
    visited[i][j] = true;
    return dfs(grid, visited, m, n, i + 1, j) + dfs(grid, visited, m, n, i - 1, j) + dfs(grid, visited, m, n, i, j + 1) + dfs(grid, visited, m, n, i, j - 1);
}

// bfs solution
略








