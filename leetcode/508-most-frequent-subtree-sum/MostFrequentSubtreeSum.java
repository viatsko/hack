import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();

    int max = Integer.MIN_VALUE;

    int maxCount = 0;

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int result = node.val + traverse(node.left) + traverse(node.right);

        int count = map.get(result);

        count++;

        if (count > max) {
            max = count;
            maxCount = 1;
        } else if (count == max) {
            maxCount++;
        }

        map.put(result, count);

        return result;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);

        int[] result = new int[maxCount];
        int resultIndex = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result[resultIndex++] = entry.getKey();
            }
        }

        return result;
    }
}
