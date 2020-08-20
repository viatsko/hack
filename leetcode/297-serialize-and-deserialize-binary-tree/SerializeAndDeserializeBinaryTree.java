/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        
        StringBuilder result = new StringBuilder();
        result.append('[');
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode element = queue.poll();
            if (element != null) {
                result.append(String.valueOf(element.val));
                queue.offer(element.left);
                queue.offer(element.right);
            } else {
                result.append("null");
            }
            
            result.append(',');
        }
        
        // Removing last "," character
        int n = result.length();
        if (n > 1) {
            result.setLength(n - 1);
        }
        
        result.append(']');
        
        return result.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0], 10));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (i < nodes.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[i + 1].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i + 1], 10));
                node.left = left;
                queue.offer(left);
            }
            if (!nodes[i + 2].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i + 2], 10));
                node.right = right;
                queue.offer(right);
            }
            i += 2;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
