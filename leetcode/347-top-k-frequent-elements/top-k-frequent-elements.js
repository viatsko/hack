/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const topKFrequent = function (nums, k) {
  const map = new Map();

  for (const num of nums) {
    if (map.has(num)) {
      map.set(num, map.get(num) + 1);
    } else {
      map.set(num, 1);
    }
  }

  const result = [...map.entries()]
    .sort((a, b) => b[1] - a[1])
    .slice(0, k)
    .map((a) => a[0]);
  return result;
};
