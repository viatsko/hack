const rotateMatrix = arr => {
    const n = arr.length;

    for (let i = 0; i < arr.length >> 1; i++) {
        for (let j = i; j < n - 1 - i; j++) {
            const tmp = arr[i][j];

            arr[i][j] = arr[j][n - 1 - i];

            arr[j][n - 1 - i] = arr[n - 1 - i][n - 1 - j];

            arr[n - 1 - i][n - 1 - j] = arr[n - j - 1][i];

            arr[n - j - 1][i] = tmp;
        }
    }

    return arr;
};

const arraysEqual = (arr1, arr2) => {
    if (arr1.length !== arr2.length) {
        return false;
    }

    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i].length !== arr2[i].length) {
            return false;
        }

        for (let j = 0; j < arr1[i].length; j++) {
            if (arr1[i][j] !== arr2[i][j]) {
                return false;
            }
        }
    }

    return true;
};

console.log(arraysEqual(rotateMatrix([
    [ 1,  2,  3,  4],
    [ 5,  6,  7,  8],
    [ 9, 10, 11, 12],
    [13, 14, 15, 16]
]), [
    [ 4,  8, 12, 16],
    [ 3,  7, 11, 15],
    [ 2,  6, 10, 14],
    [ 1,  5,  9, 13]
]));
