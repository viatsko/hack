/**
 * @param {string} S
 * @return {number[]}
 */
var partitionLabels = function (S) {
  const lastIndexes = {};

  for (let i = 0; i < S.length; i++) {
    lastIndexes[S[i]] = i;
  }

  const parititions = [];
  for (let i = 0; i < S.length; i++) {
    let start = i;
    let end = lastIndexes[S[i]];

    for (; i < end; i++) {
      end = Math.max(end, lastIndexes[S[i]]);
    }

    parititions.push(end - start + 1);
  }
  return parititions;
};
