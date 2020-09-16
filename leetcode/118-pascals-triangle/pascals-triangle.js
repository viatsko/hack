/*
[1]
[1,1]
[1,2,1]
[1,3,3,1]
[1,4,6,4,1]
*/

/**
 * @param {number} numRows
 * @return {number[][]}
 */
const generate = function (numRows) {
  if (numRows === 0) {
    return [];
  }

  const result = [[1]];

  for (let i = 1; i < numRows; i++) {
    const newRow = [];

    for (let j = 0; j < i + 1; j++) {
      newRow[j] = (result[i - 1][j - 1] || 0) + (result[i - 1][j] || 0);
    }

    result.push(newRow);
  }

  return result;
};
