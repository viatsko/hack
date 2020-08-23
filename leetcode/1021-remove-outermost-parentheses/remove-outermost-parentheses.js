/**
 * @param {string} S
 * @return {string}
 */
var removeOuterParentheses = function(S) {
  let level = 0;

  const result = [];

  for (const ch of S) {
    if (ch === '(') {
      if (level !== 0) {
        result.push(ch);
      }
      level++;
    } else if (ch === ')') {
      if (level !== 1) {
        result.push(ch);
      }
      level--;
    }
  }

  return result.join('')
};
