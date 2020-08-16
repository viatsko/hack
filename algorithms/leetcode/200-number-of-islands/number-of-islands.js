
const numIslands = grid => {
    let cnt = 0;

    const remove = (i, j) => {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] === '0') return;

        grid[i][j] = '0';

        remove(i, j + 1);
        remove(i, j - 1);
        remove(i + 1, j);
        remove(i - 1, j);
    }

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === '1') {
                remove(i, j);
                cnt++;
            }
        }
    }

    return cnt;
}
