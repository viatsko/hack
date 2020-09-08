/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

/*
   10
   / \
  5  15
 / \   \
1   8   7

*/

class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

type SubResult = {
  lowerBound: number;
  upperBound: number;
  size: number;
};

function largestBSTSubtree(root: TreeNode | null): number {
  if (!root) {
    return 0;
  }

  return largestBST(root).size;
}

function largestBST(node: TreeNode | null): SubResult {
  if (!node) {
    return {
      lowerBound: Number.MAX_SAFE_INTEGER,
      upperBound: Number.MIN_SAFE_INTEGER,
      size: 0,
    };
  }

  const left = largestBST(node.left);
  const right = largestBST(node.right);

  if (node.val > left.upperBound && node.val < right.lowerBound) {
    return {
      lowerBound: Math.min(node.val, left.lowerBound),
      upperBound: Math.max(node.val, right.upperBound),
      size: 1 + left.size + right.size,
    };
  } else {
    return {
      lowerBound: Number.MIN_SAFE_INTEGER,
      upperBound: Number.MAX_SAFE_INTEGER,
      size: Math.max(left.size, right.size),
    };
  }
}
