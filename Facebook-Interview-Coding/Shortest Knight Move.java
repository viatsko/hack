Shortest Knight Move

就是在象棋棋盘上给你两个点A，B，问 个Knight( 哥说，就是骑 那个哈)最少要 步从A跳到B。 珠从来没玩过 国际象棋，于是问Knight咋 。Turns out只要 任意朝向的L形就好。具体来说，如coordinate是(x,y) 那么在这 的 只knight可以跳到  个position中任何 个: (x-2,y-1); (x-2,y+1);(x+2,y-1);(x+2,y+1);(x-1,y+2);(x-1,y-2);(x+1,y-2);(x+1,y+2).

Solution: BFS

此题不需要建立matrix棋盘矩阵，直接使用坐标BFS即可。

public int shortestKnightMove(int a1, int a2, int b1, int b2) {
	int[][] dirs = new int[][]{{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
	Queue<int[]> q = new LinkedList<>();
	boolean[][] visited = new boolean[8][8];
	q.offer(new int[]{a1, a2});
	visited[a1][a2] = true;
	int dist = 0;
	while (!q.isEmpty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int[] pos = q.poll();
			for (int[] d : dirs) {
				int x = pos[0] + d[0], y = pos[1] + d[1];
				if (x == b1 && y == b2)		return dist + 1;
				if (x < 0 || x >= 8 || y < 0 || y >= 8 || visited[x][y])	continue;
				visited[x][y] = true;
				q.offer(new int[]{x, y});
			}
		}
		dist++;
	}
	return -1;
}
