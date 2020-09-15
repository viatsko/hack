/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
const twoSum = function (numbers, target) {
  let left = 0;
  let right = numbers.length - 1;

  while (left < right) {
    const result = numbers[left] + numbers[right];

    if (result === target) {
      return [left + 1, right + 1];
    } else if (result < target) {
      left++;
    } else {
      right--;
    }
  }

  return [];
};
