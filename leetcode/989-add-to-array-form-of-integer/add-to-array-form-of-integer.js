/**
 * @param {number[]} A
 * @param {number} K
 * @return {number[]}
 */
const addToArrayForm = function(A, K) {
  const B = [];
  while (K > 0) {
    B.unshift(K % 10);
    K = Math.floor(K / 10);
  }

  const result = [];

  let carry = 0;
  while (A.length || B.length) {
    const a = A.pop() || 0;
    const b = B.pop() || 0;

    const sum = a + b + carry;

    result.unshift(Math.floor(sum % 10));

    carry = Math.floor(sum / 10);
  }

  while (carry > 0) {
    result.unshift(carry % 10)
    carry = Math.floor(carry / 10);
  }

  return result;
};
