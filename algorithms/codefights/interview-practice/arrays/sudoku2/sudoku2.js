function sudoku2(grid) {
    const FIELD_SIZE = 9;

    const repeatedRow = [];
    const repeatedCol = [];
    const repeatedSubgrid = [];

    for (let i = 0; i < FIELD_SIZE; i++) {
        repeatedCol[i] = {};
        repeatedRow[i] = {};
    }

    for (let i = 0; i < FIELD_SIZE / 3; i++) {
        const tmpSubgrid = [];

        for (let j = 0; j < FIELD_SIZE / 3; j++) {
            tmpSubgrid.push({});
        }

        repeatedSubgrid.push(tmpSubgrid);
    }

    for (let i = 0; i < FIELD_SIZE; i++) {
        for (let j = 0; j < FIELD_SIZE; j++) {
            const el = grid[i][j];

            const subgridI = Math.floor(i / 3);
            const subgridJ = Math.floor(j / 3);

            if (el !== '.') {
                if (repeatedRow[i][el]) {
                    return false;
                }

                repeatedRow[i][el] = true;

                if (repeatedCol[j][el]) {
                    return false;
                }

                repeatedCol[j][el] = true;

                if (repeatedSubgrid[subgridI][subgridJ][el]) {
                    return false;
                }

                repeatedSubgrid[subgridI][subgridJ][el] = true;
            }
        }
    }

    return true;
}
