import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FindModeInBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int currentLength = 0;
    private int currentValue = -1;
    private int maximumLength = 0;

    private List<Integer> result = new ArrayList<>();

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (node.val != currentValue) {
            currentLength = 0;
            currentValue = node.val;
        }

        currentLength++;

        if (currentLength > maximumLength) {
            result.clear();
            maximumLength = currentLength;
        }

        if (currentLength == maximumLength) {
            result.add(node.val);
        }

        inorder(node.right);
    }

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] res = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
