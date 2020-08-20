
const searchMatrix = (matrix, target) => {
    if (!matrix.length) {
        return false;
    }

    let col = matrix[0].length - 1;
    let row = 0;

    while (col >= 0 && row < matrix.length) {
        if (matrix[row][col] === target) {
            return true;
        }

        if (matrix[row][col] > target) {
            col--
        } else {
            row++;
        }
    }

    return false;
}
