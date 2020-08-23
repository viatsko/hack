/**
 * @param {number[][]} points
 * @return {number}
 */
var minTimeToVisitAllPoints = function(points) {
  let result = 0;

  for (let i = 0; i < points.length - 1; i++) {
    result += Math.max(
      Math.abs(points[i + 1][1] - points[i][1]),
      Math.abs(points[i + 1][0] - points[i][0])
    );
  }

  return result;
};
