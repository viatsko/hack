/**
 * @param {string} s
 * @return {string[]}
 */
const removeInvalidParentheses = function(s) {
  const results = new Set();

  const buffer = [];

  let freeL = 0;
  let freeR = 0;

  for (const ch of s) {
    if (ch == '(') {
      freeL++;
    } else if (ch == ')') {
      if (freeL > 0) {
        freeL--;
      } else {
        freeR++;
      }
    }
  }

  const dfs = (pos, curFreeL, curFreeR, opened) => {
    if (curFreeL < 0 || curFreeR < 0 || opened < 0) {
      return;
    }

    if (pos === s.length) {
      if (curFreeL === 0 && curFreeR === 0 && opened === 0) {
        results.add(buffer.join(''));
      }

      return;
    }

    const len = buffer.length;
    const ch = s[pos];

    if (ch === '(') {
      dfs(pos + 1, curFreeL - 1, curFreeR, opened);
      buffer.push(ch);
      dfs(pos + 1, curFreeL, curFreeR, opened + 1);
    } else if (ch === ')') {
      dfs(pos + 1, curFreeL, curFreeR - 1, opened);
      buffer.push(ch);
      dfs(pos + 1, curFreeL, curFreeR, opened - 1);
    } else {
      buffer.push(ch);
      dfs(pos + 1, curFreeL, curFreeR, opened);
    }

    buffer.length = len;
  };

  dfs(0, freeL, freeR, 0);

  return [...results];
};
