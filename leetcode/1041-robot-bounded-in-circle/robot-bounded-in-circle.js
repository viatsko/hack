/**
 * @param {string} instructions
 * @return {boolean}
 */
const isRobotBounded = function (instructions) {
  //const visited = new Set();

  const dirs = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
  ];

  let currentDir = 0;

  let x = 0,
    y = 0;
  for (let i = 0; i < instructions.length; i++) {
    switch (instructions[i]) {
      case "G":
        console.log(currentDir);
        x += dirs[currentDir][0];
        y += dirs[currentDir][1];
        break;
      case "L":
        currentDir =
          (((currentDir - 1) % dirs.length) + dirs.length) % dirs.length;
        break;
      case "R":
        currentDir = (currentDir + 1) % dirs.length;
        break;
    }
  }

  if (currentDir !== 0 || (x === 0 && y === 0)) {
    return true;
  }

  return false;
};
