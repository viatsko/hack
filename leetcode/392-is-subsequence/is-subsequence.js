/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isSubsequence = function (t, s) {
  let si = 0;
  let ti = 0;

  while (si < s.length) {
    if (s[si++] === t[ti]) {
      ti++;
    }
  }

  return ti === t.length;
};
