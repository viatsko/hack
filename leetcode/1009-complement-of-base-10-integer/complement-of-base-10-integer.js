/**
 * @param {number} N
 * @return {number}
 */
const bitwiseComplement = function (N) {
  if (N === 0) {
    return 1;
  }

  let mask = 0;
  let comp = 1;
  let num = N;
  while (num > 0) {
    mask ^= comp;
    comp <<= 1;
    num >>= 1;
  }

  return N ^ mask;
};
