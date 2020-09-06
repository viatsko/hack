"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
"""

class Codec:
  # Encodes an n-ary tree to a binary tree.
  def encode(self, root: 'Node') -> TreeNode:
    if root == None:
      return None

    node = TreeNode(root.val)

    if len(root.children):
      node.left = self.encode(root.children[0])

    curr = node.left
    for i in range(1, len(root.children)):
      curr.right = self.encode(root.children[i])
      curr = curr.right

    return node

  # Decodes your binary tree to an n-ary tree.
  def decode(self, data: 'TreeNode') -> 'Node':
    if data == None:
      return None

    node = Node(data.val, [])

    curr = data.left
    while curr:
      node.children.append(self.decode(curr))
      curr = curr.right

    return node

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(root))
