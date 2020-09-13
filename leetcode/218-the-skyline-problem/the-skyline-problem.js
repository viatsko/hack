/**
 * @param {number[][]} buildings
 * @return {number[][]}
 */
const getSkyline = function (buildings) {
  const pointsSet = new Set();

  for (const [l, r, h] of buildings) {
    pointsSet.add(l);
    pointsSet.add(r);
  }

  const points = [...pointsSet];
  points.sort((a, b) => a - b);

  const result = [];
  for (const point of points) {
    let h = 0;
    for (let i = 0; i < buildings.length && buildings[i][0] <= point; i++) {
      if (buildings[i][1] > point) {
        h = Math.max(h, buildings[i][2]);
      }
    }
    if (result.length && result[result.length - 1][1] === h) continue;
    result.push([point, h]);
  }
  return result;
};
