/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

const findMaxIndex = (nums) => {
  let max = Number.MIN_SAFE_INTEGER;
  let idx = -1;

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] > max) {
      max = nums[i];
      idx = i;
    }
  }

  return idx;
};

/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
const constructMaximumBinaryTree = function(nums) {
  const pivot = findMaxIndex(nums);

  if (pivot === -1) {
    return null;
  }

  const node = new TreeNode(nums[pivot], null, null);

  node.left = constructMaximumBinaryTree(nums.slice(0, pivot));
  node.right = constructMaximumBinaryTree(nums.slice(pivot + 1));

  return node;
};
