/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * function ArrayReader() {
 *
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 * };
 */

/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
const search = function (reader, target) {
  let left = 0;
  let right = 10001;

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);

    const num = reader.get(mid);

    if (num > target) {
      right = mid - 1;
    } else if (num < target) {
      left = mid + 1;
    } else {
      return mid;
    }
  }

  return -1;
};
