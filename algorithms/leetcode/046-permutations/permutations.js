/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const permute = function(nums) {
  const set = new Set(nums);

  const currentPermutation = new Array(nums.length);

  const permutations = [];

  const backtrack = function(level = 0) {
    if (level === nums.length) {
      permutations.push(currentPermutation.slice());

      return;
    }

    for (let i = 0; i < nums.length; i++) {
      if (set.has(nums[i])) {
        set.delete(nums[i]);

        currentPermutation[level] = nums[i];

        backtrack(level + 1);

        set.add(nums[i]);
      }
    }
  };

  backtrack();

  return permutations;
};
