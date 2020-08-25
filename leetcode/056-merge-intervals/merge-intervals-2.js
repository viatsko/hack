/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  if (!intervals.length) {
    return [];
  }

  intervals.sort(function(a, b) {
    if (a[0] === b[0]) {
      return a[1] - b[1];
    }
    return a[0] - b[0];
  });

  const result = [intervals[0]];

  for (let i = 1; i < intervals.length; i++) {
    const prev = result[result.length - 1];
    const current = intervals[i];

    if (current[0] <= prev[1]) {
      prev[1] = Math.max(current[1], prev[1]);
    } else {
      result.push(current);
    }
  }

  return result;
};
