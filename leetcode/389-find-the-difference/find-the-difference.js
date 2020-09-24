/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
const findTheDifference = function (s, t) {
  const counter = new Array(256);
  counter.fill(0);
  for (const ch of s) {
    counter[ch.charCodeAt(0)]++;
  }
  for (const ch of t) {
    counter[ch.charCodeAt(0)]--;
  }
  for (let i = 0; i < counter.length; i++) {
    if (counter[i] !== 0) {
      return String.fromCharCode(i);
    }
  }
  return -1;
};
