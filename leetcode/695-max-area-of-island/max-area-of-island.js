const maxAreaOfIsland = grid => {
    const dfs = (i, j) => {
        let sum = 0;

        if (
            (i < 0 || i >= grid.length) ||
            (j < 0 || j >= grid[0].length) ||
            (grid[i][j] === 0)
        ) {
            return sum;
        }

        if (grid[i][j] === 1) {
            grid[i][j] = 0;
            sum += 1;
        }

        sum += dfs(i - 1, j);
        sum += dfs(i + 1, j);
        sum += dfs(i, j - 1);
        sum += dfs(i, j + 1);

        return sum;
    };

    let max = 0;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === 1) {
                max = Math.max(dfs(i, j), max);
            }
        }
    }

    return max;
};
