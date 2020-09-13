/**
 * @param {number} n
 * @return {string[]}
 */
const generateParenthesis = function (n) {
  if (n === 0) {
    return [""];
  }

  const result = [];

  for (let i = 0; i < n; i++) {
    const leftResults = generateParenthesis(i);
    const rightResults = generateParenthesis(n - i - 1);

    for (const left of leftResults) {
      for (const right of rightResults) {
        result.push("(" + left + ")" + right);
      }
    }
  }

  return result;
};
