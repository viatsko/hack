/**
 * @param {number[]} org
 * @param {number[][]} seqs
 * @return {boolean}
 */
const sequenceReconstruction = function (org, seqs) {
  const sources = org;
  const inDegree = {};
  const graph = {};

  for (const seq of seqs) {
    if (!graph[seq[0]]) {
      graph[seq[0]] = [];
    }

    if (!inDegree[seq[0]]) {
      inDegree[seq[0]] = 0;
    }

    for (let i = 0; i < seq.length - 1; i++) {
      const parent = seq[i];
      const child = seq[i + 1];

      if (!graph[parent]) {
        graph[parent] = [];
      }

      if (!inDegree[parent]) {
        inDegree[parent] = 0;
      }

      graph[parent].push(child);
      inDegree[child] = -~inDegree[child];
    }
  }

  let validCount = 0;
  for (const key of Object.keys(inDegree)) {
    if (inDegree[key] === 0) {
      validCount++;
    }
  }

  while (sources.length > 0) {
    const currSource = sources.shift();
    if (inDegree[currSource] !== 0) {
      return false;
    }

    validCount--;
    if (validCount > 0) {
      return false;
    }

    graph[currSource] &&
      graph[currSource].forEach((child) => {
        inDegree[child]--;
        if (inDegree[child] === 0) validCount++;
      });

    delete inDegree[currSource];
  }

  if (Object.keys(inDegree).length > 0) {
    return false;
  }

  return true;
};
