#include <algorithm>
#include <climits>
#include <cmath>

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
  int min = INT_MAX;
  int prev;
  bool prevIsSet = false;
public:
  void traverse(TreeNode *node) {
    if (node == nullptr) {
      return;
    }

    traverse(node->left);

    if (prevIsSet) {
      min = std::min(min, node->val - prev);
    }

    prev = node->val;
    prevIsSet = true;

    traverse(node->right);
  }

  int minDiffInBST(TreeNode* root) {
    if (root == nullptr) {
      return 0;
    }

    traverse(root);

    return min;
  }
};
