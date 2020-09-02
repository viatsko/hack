/**
 * Definition for read4()
 *
 * @param {character[]} buf Destination buffer
 * @return {number} The number of characters read
 * read4 = function(buf4) {
 *     ...
 * };
 */

/**
 * @param {function} read4()
 * @return {function}
 */
var solution = function (read4) {
  const buf4 = [];

  /**
   * @param {character[]} buf Destination buffer
   * @param {number} n Number of characters to read
   * @return {number} The number of actual characters read
   */
  return function (buf, n) {
    for (; n > 0; n--) {
      // if internal buffer empty - fill it in
      if (!buf4.length) {
        read4(buf4);
      }

      if (buf4.length) {
        buf.push(buf4.shift());
      } else {
        break;
      }
    }
  };
};
