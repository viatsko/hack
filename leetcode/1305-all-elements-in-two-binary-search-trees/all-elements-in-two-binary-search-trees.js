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
  const stack1 = [];
  const stack2 = [];

  const res = [];
  while (root1 || root2 || stack1.length || stack2.length) {
    while (root1) {
      stack1.push(root1);
      root1 = root1.left;
    }

    while (root2) {
      stack2.push(root2);
      root2 = root2.left;
    }

    if (
      stack1.length > 0 &&
      (stack2.length === 0 ||
        stack1[stack1.length - 1].val < stack2[stack2.length - 1].val)
    ) {
      const el = stack1.pop();

      res.push(el.val);

      if (el.right) {
        root1 = el.right;
      }
    } else {
      const el = stack2.pop();

      res.push(el.val);

      if (el.right) {
        root2 = el.right;
      }
    }
  }

  return res;
};
