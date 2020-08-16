/**
 * @param {number[][]} arr
 * @return {number}
 */
const matrixScore = function(arr) {
  const zeroes = [];

  for (let i = 0; i < arr.length; i++) {
    const needsFlip = arr[i][0] === 0;

    for (let j = 0; j < arr[i].length; j++) {
      if (needsFlip) {
        arr[i][j] ^= 1;
      }

      if (arr[i][j] === 0) {
        zeroes[j] = -~zeroes[j];
      }
    }
  }

  const h = arr.length >> 1;
  for (let i = 1; i < arr[0].length; i++) {
    if (zeroes[i] > h) {
      for (let j = 0; j < arr.length; j++) {
        arr[j][i] ^= 1;
      }
    }
  }

  let result = 0;

  for (let i = 0; i < arr.length; i++) {
    let currentResult = 0;

    for (let j = 0; j < arr[0].length; j++) {
      currentResult = (currentResult << 1) | arr[i][j];
    }

    result += currentResult;
  }

  return result;
};
