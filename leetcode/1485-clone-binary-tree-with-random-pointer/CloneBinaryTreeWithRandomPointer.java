/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
  public NodeCopy copyRandomBinaryTree(Node root) {
    Map<Node, NodeCopy> map = new HashMap<>();

    NodeCopy rootCopy = helper(root, map);

    helperRandom(root, rootCopy, map);

    return rootCopy;
  }

  protected NodeCopy helper(Node node, Map<Node, NodeCopy> map) {
    if (node == null) {
      return null;
    }

    NodeCopy nodeCopy = new NodeCopy(node.val);

    map.put(node, nodeCopy);

    nodeCopy.left = helper(node.left, map);
    nodeCopy.right = helper(node.right, map);

    return nodeCopy;
  }

  protected void helperRandom(Node node, NodeCopy nodeCopy, Map<Node, NodeCopy> map) {
    if (node == null) {
      return;
    }

    nodeCopy.random = map.get(node.random);

    helperRandom(node.left, nodeCopy.left, map);
    helperRandom(node.right, nodeCopy.right, map);
  }
}
