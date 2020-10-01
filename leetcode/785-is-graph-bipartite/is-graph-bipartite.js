/**
 * @param {number[][]} graph
 * @return {boolean}
 */
const isBipartite = function (graph) {
  const colors = new Array(graph.length).fill(-1);

  for (let parent = 0; parent < graph.length; parent++) {
    if (colors[parent] === -1) {
      const stack = [];
      stack.push(parent);
      colors[parent] = 0;

      while (stack.length > 0) {
        const curr = stack.pop();

        for (const node of graph[curr]) {
          if (colors[node] === -1) {
            colors[node] = colors[curr] ^ 1;
            stack.push(node);
          } else if (colors[node] === colors[curr]) {
            return false;
          }
        }
      }
    }
  }

  return true;
};
