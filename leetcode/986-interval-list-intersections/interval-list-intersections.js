/**
 * @param {number[][]} A
 * @param {number[][]} B
 * @return {number[][]}
 */
var intervalIntersection = function(A, B) {
  const result = [];

  let i = 0, j = 0;

  while (i < A.length && j < B.length) {
    let left = Math.max(A[i][0], B[j][0]);
    let right = Math.min(A[i][1], B[j][1]);

    if (left <= right) {
      result.push([left, right]);
    }

    if (A[i][1] < B[j][1]) {
      i++;
    } else {
      j++;
    }
  }

  return result;
};
