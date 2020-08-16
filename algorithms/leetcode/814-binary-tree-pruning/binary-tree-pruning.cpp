class Solution {
public:
  struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  };

  int bfs(TreeNode *node) {
    if (node == nullptr) {
      return 0;
    }

    int left = bfs(node->left);

    if (left == 0) {
      node->left = nullptr;
    }

    int right = bfs(node->right);

    if (right == 0) {
      node->right = nullptr;
    }

    return left + right + node->val;
  }

  TreeNode* pruneTree(TreeNode* root) {
    if (root != nullptr) {
      bfs(root);
    }

    return root;
  }
};
