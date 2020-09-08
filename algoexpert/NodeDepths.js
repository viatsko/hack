function nodeDepths(root) {
  let sumOfDepths = 0;

  const helper = (node, depth = 0) => {
    if (!node) {
      return;
    }

    sumOfDepths += depth;

    helper(node.left, depth + 1);
    helper(node.right, depth + 1);
  };

  helper(root);

  return sumOfDepths;
}

// This is the class of the input binary tree.
class BinaryTree {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

// Do not edit the line below.
exports.nodeDepths = nodeDepths;
