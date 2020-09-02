/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} t
 * @return {boolean}
 */
var containsNearbyAlmostDuplicate = function (nums, k, t) {
  const mn = nums.map((num, index) => ({ num, index }));
  mn.sort((a, b) => {
    return a.num - b.num;
  });
  let l = 0;
  let r = 1;
  while (r < mn.length) {
    let vdiff = Math.abs(mn[r].num - mn[l].num);
    let idiff = Math.abs(mn[r].index - mn[l].index);

    if (vdiff <= t && idiff <= k) {
      return true;
    } else if (vdiff > t) {
      l++;
    } else if (idiff > k) {
      r++;
    }

    if (l === r) {
      r++;
    }
  }
  return false;
  return false;
};
