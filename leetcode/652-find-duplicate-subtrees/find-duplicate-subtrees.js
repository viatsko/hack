const serializeTree = (root) => {
  const result = [];

  const helper = (node) => {
    if (node === null) {
      result.push("null");
      return;
    }

    result.push(node.val);

    helper(node.left);
    helper(node.right);
  };

  helper(root);

  return result.toString();
};

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode[]}
 */
const findDuplicateSubtrees = function (root) {
  const map = new Map();

  const helper = (node) => {
    if (node === null) {
      return;
    }

    const serialized = serializeTree(node);

    if (map.has(serialized)) {
      map.set(serialized, {
        node,
        count: map.get(serialized).count + 1,
      });
    } else {
      map.set(serialized, {
        node,
        count: 1,
      });
    }

    helper(node.left);
    helper(node.right);
  };

  helper(root);

  const result = [];
  for (const [key, value] of map.entries()) {
    if (value.count > 1) {
      result.push(value.node);
    }
  }
  return result;
};
