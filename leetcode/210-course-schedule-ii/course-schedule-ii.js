/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
const findOrder = function (numCourses, prerequisites) {
  const result = [];
  const stack = [];
  const inDegree = new Array(numCourses).fill(0);

  for (let i = 0; i < prerequisites.length; i++) {
    inDegree[prerequisites[i][0]]++;
  }

  for (let i = 0; i < inDegree.length; i++) {
    if (inDegree[i] === 0) {
      stack.push(i);
    }
  }

  while (stack.length > 0) {
    const curr = stack.pop();

    result.push(curr);

    for (let i = 0; i < prerequisites.length; i++) {
      if (prerequisites[i][1] === curr) {
        inDegree[prerequisites[i][0]]--;

        if (inDegree[prerequisites[i][0]] === 0) {
          stack.push(prerequisites[i][0]);
        }
      }
    }
  }

  if (result.length === numCourses) {
    return result;
  } else {
    return [];
  }
};
