/**
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */
const findJudge = function(N, trust) {
  const degree = new Array(N + 1).fill(0);

  for (const [outDegree, inDegree] of trust) {
    degree[outDegree]--;
    degree[inDegree]++;
  }

  for (let i = 1; i <= N; i++) {
    if (degree[i] === N - 1) {
      return i;
    }
  }

  return -1;
};
