/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * function Robot() {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     @return {boolean}
 *     this.move = function() {
 *         ...
 *     };
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     @return {void}
 *     this.turnLeft = function() {
 *         ...
 *     };
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     @return {void}
 *     this.turnRight = function() {
 *         ...
 *     };
 *
 *     // Clean the current cell.
 *     @return {void}
 *     this.clean = function() {
 *         ...
 *     };
 * };
 */

/**
 * @param {Robot} robot
 * @return {void}
 */
const cleanRoom = function (robot) {
  const visited = new Set();

  const dirs = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
  ];

  const helper = (x, y, dir) => {
    if (visited.has(`${x},${y}`)) {
      return;
    }

    visited.add(`${x},${y}`);

    robot.clean();

    for (let i = 0; i < 4; i++) {
      if (robot.move()) {
        const newX = x + dirs[dir][0];
        const newY = y + dirs[dir][1];

        helper(newX, newY, dir);

        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
      }

      robot.turnRight();

      dir += 1;
      dir %= 4;
    }
  };

  helper(0, 0, 0);
};
