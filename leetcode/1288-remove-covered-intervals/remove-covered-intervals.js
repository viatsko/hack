/**
 * @param {number[][]} intervals
 * @return {number}
 */
const removeCoveredIntervals = function (intervals) {
  intervals.sort((a, b) => {
    return a[0] - b[0];
  });

  let start = -1;
  let end = -1;

  let count = 0;

  for (const interval of intervals) {
    if (interval[0] > start && interval[1] > end) {
      start = interval[0];
      count++;
    }

    end = Math.max(end, interval[1]);
  }

  return count;
};
