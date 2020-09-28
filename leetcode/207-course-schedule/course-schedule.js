/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
const canFinish = function (numCourses, prerequisites) {
  const inDegree = new Array(numCourses).fill(0);

  for (let i = 0; i < prerequisites.length; i++) {
    inDegree[prerequisites[i][0]]++;
  }

  const sources = [];
  for (let i = 0; i < inDegree.length; i++) {
    if (inDegree[i] === 0) {
      sources.push(i);
    }
  }

  let count = 0;
  while (sources.length > 0) {
    const curr = sources.pop();

    count++;

    for (let i = 0; i < prerequisites.length; i++) {
      if (prerequisites[i][1] === curr) {
        inDegree[prerequisites[i][0]]--;

        if (inDegree[prerequisites[i][0]] === 0) {
          sources.push(prerequisites[i][0]);
        }
      }
    }
  }

  return count === numCourses;
};
