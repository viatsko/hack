Shifting Matrix

一个m x n 的 array 只有 0 和 1  给一个 int k 
需要把 小于 k 数量 连续的 1 变成 0
连续： 上下左右和四个斜线方向
这题说的是，当island的面积小于k的时候，把1翻成0


思路：先做dfs来计算面积并把1翻成2，如果面积小于k，再做一次dfs把2翻成0. 最后再把所有的2翻成0
这题直接bfs就可以了。union find的精髓在于要不断的merge，图是动态变化的，eg：number of islands ii那道题有新的点加进来。


Solution 1: 2 DFS 

int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
int size = 0;
public void shiftingMatrix(char[][] grid, int k) {
	int m = grid.length, n = grid[0].length;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++) {
			if (grid[i][j] == '1') {
				size = 0;
				dfsSize(grid, i, j); 
				if (size < k) {// size < k, change original '1'(now '2') to 0
					dfsChange(grid, i, j);
				}
			}
		}
	// final shift : change '2'(island whose size >= k) back to '1'
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++) 
			if (grid[i][j] == '2')	grid[i][j] = '1';
}
private void dfsSize(char[][] grid, int i, int j) {
	if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')	
		return;
	grid[i][j] = '2';
	size++;
	for (int[] d : dirs) 
		dfsSize(grid, i + d[0], j + d[1]);
}
private void dfsChange(char[][] grid, int i, int j) {
	if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '2')	
		return;
	grid[i][j] = '0';
	for (int[] d : dirs) 
		dfsChange(grid, i + d[0], j + d[1]);
}