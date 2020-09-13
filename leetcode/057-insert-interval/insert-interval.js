/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function (intervals, newInterval) {
  if (!intervals.length) {
    if (newInterval) {
      return [newInterval];
    } else {
      return [];
    }
  }

  intervals.push(newInterval);

  intervals.sort((a, b) => {
    if (a[0] === b[0]) {
      return a[1] - b[1];
    }

    return a[0] - b[0];
  });

  const result = [];

  for (let i = 0; i < intervals.length; i++) {
    let currentInterval = intervals[i];
    console.log(currentInterval);

    while (
      i < intervals.length - 1 &&
      intervals[i + 1][0] <= currentInterval[1]
    ) {
      currentInterval[1] = Math.max(intervals[i + 1][1], currentInterval[1]);
      i++;
    }

    result.push(currentInterval);
  }

  return result;
};
