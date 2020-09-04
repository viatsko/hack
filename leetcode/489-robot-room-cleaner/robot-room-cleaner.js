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
var cleanRoom = function (robot) {
  const visited = new Set();

  const helper = (x, y, angle) => {
    const move = `${x},${y}`;

    if (visited.has(move)) {
      return;
    }

    robot.clean();

    visited.add(move);

    for (let i = 0; i < 4; i++) {
      if (robot.move()) {
        switch (angle) {
          case 0:
            helper(x, y + 1, angle);
            break;
          case 90:
            helper(x + 1, y, angle);
            break;
          case 180:
            helper(x, y - 1, angle);
            break;
          case 270:
            helper(x - 1, y, angle);
            break;
        }

        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
      }
      robot.turnRight();
      angle += 90;
      angle %= 360;
    }
  };

  helper(0, 0, 0);
};
