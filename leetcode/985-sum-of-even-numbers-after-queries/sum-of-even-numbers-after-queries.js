/**
 * @param {number[]} A
 * @param {number[][]} queries
 * @return {number[]}
 */
const sumEvenAfterQueries = function (A, queries) {
  let sum = 0;
  for (const num of A) if (num % 2 === 0) sum += num;

  const result = [];

  for (const [val, index] of queries) {
    if (A[index] % 2 === 0) sum -= A[index];

    A[index] += val;

    if (A[index] % 2 === 0) sum += A[index];

    result.push(sum);
  }

  return result;
};
