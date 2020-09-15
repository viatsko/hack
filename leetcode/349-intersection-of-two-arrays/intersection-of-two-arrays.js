/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
const intersection = function (nums1, nums2) {
  const set = new Set();

  for (const num of nums1) {
    set.add(num);
  }

  const result = new Set();
  for (const num of nums2) {
    if (set.has(num)) {
      result.add(num);
    }
  }

  return [...result];
};
