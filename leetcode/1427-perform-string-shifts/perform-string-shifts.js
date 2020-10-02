/**
 * @param {string} s
 * @param {number[][]} shift
 * @return {string}
 */
const stringShift = function(s, shift) {
  let start = 0;
  for (const [direction, amount] of shift) {
    if (direction === 0) {
      start += amount;
    } else {
      start -= amount;
    }
  }

  start = ((start % s.length) + s.length) % s.length;

  return s.substring(start) + s.substring(0, start);
};
