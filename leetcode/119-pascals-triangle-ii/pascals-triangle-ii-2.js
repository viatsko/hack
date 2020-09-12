/**
 * @param {number} rowIndex
 * @return {number[]}
 */
const getRow = function (rowIndex) {
  const result = Array(rowIndex + 1).fill(1);

  for (let i = 1; i < rowIndex; i++) {
    for (let j = i; j >= 1; j--) {
      result[j] += result[j - 1];
    }
  }

  return result;
};
