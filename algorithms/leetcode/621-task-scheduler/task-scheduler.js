/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
const leastInterval = function(tasks, n) {
  if (tasks.length === 0) {
    return 0;
  }

  let max = -1;
  let maxed = 0;
  const map = {};

  for (const task of tasks) {
    map[task] = -~map[task];
    if (map[task] === max) {
      maxed++;
    } else if (map[task] > max) {
      max = map[task];
      maxed = 1;
    }
  }

  return Math.max(tasks.length, n * (max - 1) + maxed + max - 1);
};
