/**
 * @param {string} s
 * @return {string}
 */
const reformat = function(s) {
  const digits = [];
  const chars = [];

  for (const ch of s)
    if (ch >= 'a' && ch <= 'z')
      chars.push(ch);
    else
      digits.push(ch)

  if (Math.abs(chars.length - digits.length) > 1)
    return '';

  const arrs = [digits, chars].sort((a, b) => b.length - a.length);
  const result = new Array(digits.length + chars.length);
  for (let i = 0; i < result.length; i++) {
    result[i] = arrs[i % 2].pop();
  }
  return result.join('');
};
