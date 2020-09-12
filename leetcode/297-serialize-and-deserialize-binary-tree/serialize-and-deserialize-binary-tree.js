/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
const serialize = function (root) {
  const result = [];

  const dfs = (root) => {
    if (root === null) {
      result.push(null);
      return;
    }

    result.push(root.val);

    dfs(root.left);
    dfs(root.right);
  };

  dfs(root);

  return result;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
const deserialize = function (data) {
  const helper = () => {
    if (data[0] === null) {
      data.shift();
      return null;
    }

    const node = new TreeNode(data.shift());

    node.left = helper();
    node.right = helper();

    return node;
  };

  return helper(data);
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
