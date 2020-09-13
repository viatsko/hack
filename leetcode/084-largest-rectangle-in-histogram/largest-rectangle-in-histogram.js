/**
 * @param {number[]} heights
 * @return {number}
 */
const largestRectangleArea = function (heights) {
  let result = 0;

  const stackPositions = [];
  const stackHeights = [];

  for (let i = 0; i < heights.length; i++) {
    const h = heights[i];

    if (!stackHeights.length || h > stackHeights[stackHeights.length - 1]) {
      stackPositions.push(i);
      stackHeights.push(h);
    } else {
      let tempPosition = i;
      while (
        stackHeights.length > 0 &&
        h < stackHeights[stackHeights.length - 1]
      ) {
        let tempHeight = stackHeights.pop();
        tempPosition = stackPositions.pop();

        let tempSize = tempHeight * (i - tempPosition);

        result = Math.max(result, tempSize);
      }
      stackPositions.push(tempPosition);
      stackHeights.push(h);
    }
  }

  while (stackHeights.length > 0) {
    let tempHeight = stackHeights.pop();
    let tempPosition = stackPositions.pop();

    let tempSize = tempHeight * (heights.length - tempPosition);

    result = Math.max(result, tempSize);
  }

  return result;
};
