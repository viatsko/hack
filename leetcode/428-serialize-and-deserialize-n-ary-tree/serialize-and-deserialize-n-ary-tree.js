/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

class Codec {
  constructor() {}

  /**
   * @param {Node} root
   * @return {string}
   */
  // Encodes a tree to a single string.
  serialize = function (root) {
    if (!root) {
      return "";
    }
    return (
      root.val +
      "(" +
      root.children.map((el) => this.serialize(el)).join(",") +
      ")"
    );
  };

  /**
   * @param {string} data
   * @return {Node}
   */
  // Decodes your encoded data to tree.
  deserialize = function (data) {
    if (!data) return null;
    const strVal = data.substring(0, data.indexOf("("));
    const val = +strVal;

    const node = new Node(val, []);

    let child = "";
    let level = 1;
    for (let i = data.indexOf("(") + 1; i < data.length; i++) {
      if (data[i] === "," && level === 1) {
        node.children.push(this.deserialize(child));
        child = "";
      } else if (data[i] === "(") {
        level++;
        child += data[i];
      } else if (data[i] === ")") {
        level--;
        if (level === 0) {
          child !== "" && node.children.push(this.deserialize(child));
          child = "";
        } else {
          child += data[i];
        }
      } else {
        child += data[i];
      }
    }

    return node;
  };
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
