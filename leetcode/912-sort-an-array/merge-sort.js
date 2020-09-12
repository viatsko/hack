/**
 * @param {number[]} nums
 * @return {number[]}
 */
const sortArray = function (nums) {
  return mergeSort(nums);
};

const mergeSort = (nums) => {
  if (nums.length <= 1) {
    return nums;
  }

  const mid = Math.floor(nums.length / 2);
  const left = mergeSort(nums.slice(0, mid));
  const right = mergeSort(nums.slice(mid));

  return merge(left, right);
};

const merge = (left, right) => {
  const result = [];

  while (left.length && right.length) {
    if (left[0] < right[0]) {
      result.push(left.shift());
    } else {
      result.push(right.shift());
    }
  }

  return [...result, ...left, ...right];
};
