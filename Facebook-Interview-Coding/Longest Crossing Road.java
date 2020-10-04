Longest Crossing Road

题目：矩阵中由1构成的一横一竖的连续的1，并且这一横一竖有一个交叉点的， 是一条十字路. 
总的来说对每一个1：和他在同一列上，与他相连的的连续的1的数量 + 和同他在同一行上，与他相连的连续的1的数量的和  就是以当前1为交叉点的十字路的长度
找出矩阵中最长的十字路。
举几个例子吧. 

0 0 0
1 1 1
1 0 0   中最长的十字路长度是4

0 0 1 0 0 0
0 0 1 1 1 1
1 1 1 0 1 0
0 0 1 0 0 1
   中最长的十字路长度是7

public int maxKilledEnemies(char[][] grid) {	
	int m = grid.length, n = grid[0].length;
	int rowCount = 0, res = 0;
	int[] colCount = new int[n];
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++) {
			if (j == 0) {
				rowCount = 0;
				for (int k = 0; k < n; k++)
					rowCount += grid[i][k] == 1 ? 1 : 0;
			}
			if (i == 0) {
				colCount[j] = 0;
				for (int k = 0; k < m; k++) 
					colCount[j] += grid[k][j] == 1 ? 1 : 0; 
			}
			if (grid[i][j] == 1) 
				res = Math.max(res, rowCount + colCount[j] - 1);
		}
	return res;
}