/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

class Codec {
  constructor() {}

  /**
   * @param {Node} root
   * @return {TreeNode}
   */
  // Encodes an n-ary tree to a binary tree.
  encode = function (root) {
    if (!root) {
      return null;
    }

    const node = new TreeNode(root.val);

    if (root.children.length) {
      node.left = this.encode(root.children[0]);
    }

    let curr = node.left;
    for (let i = 1; i < root.children.length; i++) {
      curr.right = this.encode(root.children[i]);
      curr = curr.right;
    }

    return node;
  };

  /**
   * @param {TreeNode} root
   * @return {Node}
   */
  // Decodes your binary tree to an n-ary tree.
  decode = function (root) {
    if (!root) {
      return null;
    }

    const node = new Node(root.val, []);

    let curr = root.left;
    while (curr) {
      node.children.push(this.decode(curr));
      curr = curr.right;
    }

    return node;
  };
}

/*
 * Your Codec object will be instantiated and called as such:
 * codec = Codec()
 * codec.decode(codec.encode(root))
 */
