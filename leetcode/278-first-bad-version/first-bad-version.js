/**
 * Definition for isBadVersion()
 *
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
const solution = function (isBadVersion) {
  /**
   * @param {integer} n Total versions
   * @return {integer} The first bad version
   */
  return function (n) {
    let left = 1;
    let right = n;

    while (left <= right) {
      const mid = Math.floor(left + (right - left) / 2);

      const prev = isBadVersion(mid - 1);
      const curr = isBadVersion(mid);

      if ((mid === 1 && curr) || (!prev && curr)) {
        return mid;
      } else if (curr) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  };
};
