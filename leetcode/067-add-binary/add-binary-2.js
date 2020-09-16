/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
const addBinary = function (a, b) {
  let n = Math.max(a.length, b.length);

  const result = [];
  let carry = 0;
  for (let i = 0; i < n; i++) {
    carry +=
      (a[a.length - 1 - i] === "1" ? 1 : 0) +
      (b[b.length - 1 - i] === "1" ? 1 : 0);
    result.unshift(carry % 2);
    carry = Math.floor(carry / 2);
  }

  while (carry-- > 0) {
    result.unshift(1);
  }

  return result.join("");
};
