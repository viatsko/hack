/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {number[]}
 */
var getAllElements = function (root1, root2) {
  const res = [];

  const s1 = [];
  const s2 = [];

  while (root1 || root2 || s1.length || s2.length) {
    while (root1) {
      s1.push(root1);
      root1 = root1.left;
    }

    while (root2) {
      s2.push(root2);
      root2 = root2.left;
    }

    if (
      !s2.length ||
      (s1.length && s1[s1.length - 1].val <= s2[s2.length - 1].val)
    ) {
      const el = s1.pop();
      res.push(el.val);
      if (el.right) {
        root1 = el.right;
      }
    } else {
      const el = s2.pop();
      res.push(el.val);
      if (el.right) {
        root2 = el.right;
      }
    }
  }

  return res;
};
