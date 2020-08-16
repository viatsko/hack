/**
 * @param {number[][]} wall
 * @return {number}
 */
const leastBricks = function(wall) {
  if (wall.length === 0) {
    return 0;
  }

  let bricks = {};
  let wallLength = 0;
  for (const row of wall) {
    let position = 0;
    for (const brick of row) {
      position += brick;
      bricks[position] = -~bricks[position];
      wallLength = position;
    }
  }

  let max = 0;

  for (const key in bricks) {
    if (key != wallLength) {
      max = Math.max(max, bricks[key]);
    }
  }

  return wall.length - max;
};
