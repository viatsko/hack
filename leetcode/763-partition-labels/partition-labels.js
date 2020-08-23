/**
 * @param {string} S
 * @return {number[]}
 */
var partitionLabels = function(S) {
  const last = {};
  for (let i = 0; i < S.length; i++) {
    last[S[i]] = i;
  }

  const result = [];
  for (let i = 0; i < S.length; i++) {
    let closesAt = last[S[i]];

    for (let j = i; j < closesAt; j++) {
      closesAt = Math.max(closesAt, last[S[j]]);
    }

    result.push(closesAt - i + 1);
    i = closesAt;
  }
  return result;
};
