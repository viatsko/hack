/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
  int diameter(Node* root) {
    int result = 0;

    helper(root, &result);

    return result;
  }
private:
  int helper(Node* root, int* result) {
    int maxVal = 0;
    int secondMaxVal = 0;

    for (int i = 0; i < root->children.size(); i++) {
      int res = helper(root->children[i], result);
      if (res > maxVal) {
        secondMaxVal = maxVal;
        maxVal = res;
      } else if (res > secondMaxVal) {
        secondMaxVal = res;
      }
    }

    *result = max(*result, maxVal + secondMaxVal);

    return 1 + maxVal;
  }
};
