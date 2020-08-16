const spiralOrder = matrix => {
    const result = [];

    const r = matrix.length;

    if (r === 0) {
        return result;
    }

    const c = matrix[0].length;

    let n = r * c;

    let minX = 0, minY = 0, maxX = c - 1, maxY = r - 1;

    while (n > 0) {
        for (let i = minX; i <= maxX && n > 0; i++) {
            result.push(matrix[minY][i]);
            n--;
        }

        minY++;

        for (let i = minY; i <= maxY && n > 0; i++) {
            result.push(matrix[i][maxX]);
            n--;
        }

        maxX--;

        for (let i = maxX; i >= minX && n > 0; i--) {
            result.push(matrix[maxY][i]);
            n--;
        }

        maxY--;

        for (let i = maxY; i >= minY && n > 0; i--) {
            result.push(matrix[i][minX]);
            n--;
        }

        minX++;
    }

    return result;
};
