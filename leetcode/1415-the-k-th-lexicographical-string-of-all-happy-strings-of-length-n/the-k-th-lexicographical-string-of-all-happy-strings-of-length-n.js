/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
const getHappyString = function(n, k) {
  let result = "";
  let buf = [];
  const dfs = (n, prev) => {
    if (n === 0) {
      k--;
      if (k === 0) {
        result = buf.join('');
      }
      return;
    }
    for (let i = 0; i < 3; i++) {
      if (i === prev) {
        continue;
      }

      buf.push(String.fromCharCode('a'.charCodeAt(0) + i));

      dfs(n - 1, i);

      buf.pop();
    }
  };

  dfs(n, -1);

  return result;
};
