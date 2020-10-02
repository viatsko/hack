/**
 * @param {string[]} queries
 * @param {string[]} words
 * @return {number[]}
 */
const numSmallerByFrequency = function (queries, words) {
  const freqs = [];
  for (let i = 0; i < words.length; i++) freqs[i] = f(words[i]);

  const result = [];
  for (const query of queries) {
    let count = 0;
    const queryFreq = f(query);
    for (const freq of freqs) if (freq > queryFreq) count++;
    result.push(count);
  }
  return result;
};

const f = (s) => {
  let minChar = "~";
  for (const ch of s) if (ch < minChar) minChar = ch;

  let count = 0;
  for (const ch of s) if (ch === minChar) count++;

  return count;
};
