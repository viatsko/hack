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
const solution = function(isBadVersion) {
  /**
   * @param {integer} n Total versions
   * @return {integer} The first bad version
   */
  return function(n) {
    let min = 0;
    let max = n;

    while (min < max) {
      const mid = (min + max) >>> 1;

      if (!isBadVersion(mid)) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }

    return min;
  };
};
