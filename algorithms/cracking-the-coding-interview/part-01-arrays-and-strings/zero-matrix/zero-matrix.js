const zeroMatrix = arr => {
    let firstRowZeroes = false;
    let firstColZeroes = false;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i][0] === 0) {
            firstColZeroes = true;
        }
    }

    for (let j = 0; j < arr[0].length; j++) {
        if (arr[0][j] === 0) {
            firstRowZeroes = true;
        }
    }

    for (let i = 1; i < arr.length; i++) {
        for (let j = 1; j < arr[0].length; j++) {
            if (arr[i][j] === 0) {
                arr[i][0] = 0;
                arr[0][j] = 0;
            }
        }
    }

    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[0].length; j++) {
            if (arr[i][0] === 0 || arr[0][j] === 0) {
                arr[i][j] = 0;
            }
        }
    }

    if (firstColZeroes) {
        for (let i = 0; i < arr.length; i++) {
            arr[i][0] = 0;
        }
    }

    if (firstRowZeroes) {
        for (let j = 0; j < arr.length; j++) {
            arr[0][j] = 0;
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

console.log(arraysEqual(zeroMatrix([
    [ 1,  0,  3,  4],
    [ 5,  6,  7,  8],
    [ 9,  0, 11, 12],
    [13, 14, 15,  0]
]), [
    [ 0,  0,  0,  0],
    [ 5,  0,  7,  0],
    [ 0,  0,  0,  0],
    [ 0,  0,  0,  0]
]));
