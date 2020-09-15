/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function (nums1, nums2) {
  const map1 = new Map();
  const map2 = new Map();

  for (const num of nums1) {
    if (map1.has(num)) {
      map1.set(num, map1.get(num) + 1);
    } else {
      map1.set(num, 1);
    }
  }

  for (const num of nums2) {
    if (map2.has(num)) {
      map2.set(num, map2.get(num) + 1);
    } else {
      map2.set(num, 1);
    }
  }

  const result = [];
  for (const [key, value1] of map1) {
    const value2 = map2.get(key) || 0;

    let els = Math.min(value1, value2);
    const subres = [];
    while (els-- > 0) {
      subres.push(key);
    }
    result.push(...subres);
  }

  return result;
};
