function spiralTraverse(array) {
  const N = array.length * array[0].length;

  const res = [];

  let topBorder = 0;
  let bottomBorder = array.length - 1;
  let leftBorder = 0;
  let rightBorder = array[0].length - 1;

  while (res.length < N) {
    for (let i = leftBorder; res.length < N && i <= rightBorder; i++) {
      res.push(array[topBorder][i]);
    }
    topBorder++;
    for (let i = topBorder; res.length < N && i <= bottomBorder; i++) {
      res.push(array[i][rightBorder]);
    }
    rightBorder--;
    for (let i = rightBorder; res.length < N && i >= leftBorder; i--) {
      res.push(array[bottomBorder][i]);
    }
    bottomBorder--;
    for (let i = bottomBorder; res.length < N && i >= topBorder; i--) {
      res.push(array[i][leftBorder]);
    }
    leftBorder++;
  }

  return res;
}

// Do not edit the line below.
exports.spiralTraverse = spiralTraverse;
