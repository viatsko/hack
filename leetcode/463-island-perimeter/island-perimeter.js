const islandPerimeter = grid => {
    let p = 0;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] !== 1) {
                continue;
            }

            let isles = 0;

            if (i > 0 && grid[i - 1][j] === 1) {
                isles++;
            }

            if (i < (grid.length - 1) && grid[i + 1][j] === 1) {
                isles++;
            }

            if (j > 0 && grid[i][j - 1] === 1) {
                isles++;
            }

            if (j < (grid[0].length - 1) && grid[i][j + 1] === 1) {
                isles++;
            }

            p += (4 - isles);
        }
    }

    return p;
};
