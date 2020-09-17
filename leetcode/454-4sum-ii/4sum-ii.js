/**
 * @param {number[]} A
 * @param {number[]} B
 * @param {number[]} C
 * @param {number[]} D
 * @return {number}
 */
const fourSumCount = function (A, B, C, D) {
  const map = new Map();

  for (const a of A) {
    for (const b of B) {
      const sum = a + b;
      if (map.has(sum)) {
        map.set(sum, map.get(sum) + 1);
      } else {
        map.set(sum, 1);
      }
    }
  }

  let result = 0;
  for (const c of C) {
    for (const d of D) {
      const sum = c + d;
      if (map.has(-sum)) {
        result += map.get(-sum);
      }
    }
  }

  return result;
};
