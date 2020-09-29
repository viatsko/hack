/**
 * @param {string[]} words
 * @return {string}
 */
const alienOrder = function (words) {
  const inDegree = {};
  const graph = {};

  for (const word of words) {
    for (const ch of word) {
      inDegree[ch] = 0;
      graph[ch] = [];
    }
  }

  for (let i = 0; i < words.length - 1; i++) {
    const word1 = words[i];
    const word2 = words[i + 1];

    if (word1.length > word2.length && word1.startsWith(word2)) {
      return "";
    }

    for (let j = 0; j < Math.min(word1.length, word2.length); j++) {
      const ch1 = word1[j];
      const ch2 = word2[j];

      if (ch1 !== ch2) {
        graph[ch1].push(ch2);
        inDegree[ch2]++;
        break;
      }
    }
  }

  const sources = [];
  for (const [key, value] of Object.entries(inDegree)) {
    if (value === 0) {
      sources.push(key);
    }
  }

  const result = [];

  while (sources.length > 0) {
    const curr = sources.shift();
    result.push(curr);
    for (const child of graph[curr]) {
      inDegree[child]--;
      if (inDegree[child] === 0) {
        sources.push(child);
      }
    }
  }

  if (result.length !== Object.keys(inDegree).length) {
    return "";
  }

  return result.join("");
};
