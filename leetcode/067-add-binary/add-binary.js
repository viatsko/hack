/**
 * @param {string} aStr
 * @param {string} bStr
 * @return {string}
 */
const addBinary = function (aStr, bStr) {
  const a = BigInt(`0b${aStr}`);
  const b = BigInt(`0b${bStr}`);
  return (a + b).toString(2);
};
