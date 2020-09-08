// This is the class of the input root.
// Do not edit it.
class BinaryTree {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function branchSums(root) {
  const result = [];
  helper(root, 0, result);
  return result;
}

function helper(root, sum = 0, result) {
  if (!root) {
    return;
  }

  const newSum = sum + root.value;
  if (!root.left && !root.right) {
    result.push(newSum);
  }

  helper(root.left, newSum, result);
  helper(root.right, newSum, result);
}

// Do not edit the lines below.
exports.BinaryTree = BinaryTree;
exports.branchSums = branchSums;
