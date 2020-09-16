/**
 * @param {number[]} digits
 * @return {number[]}
 */
const plusOne = function (digits) {
  let carry = 1;

  for (let i = digits.length - 1; i >= 0; i--) {
    digits[i] += carry;
    if (digits[i] === 10) {
      carry = 1;
      digits[i] = 0;
    } else {
      carry = 0;
    }
  }

  if (carry) {
    digits.unshift(carry);
  }

  return digits;
};
