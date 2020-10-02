/**
 * @param {string[]} logs
 * @return {number}
 */
const minOperations = function (logs) {
  let min = 0;

  for (const log of logs) {
    if (log === "../") {
      if (min > 0) {
        min--;
      }
    } else if (log !== "./") {
      min++;
    }
  }

  return min;
};
