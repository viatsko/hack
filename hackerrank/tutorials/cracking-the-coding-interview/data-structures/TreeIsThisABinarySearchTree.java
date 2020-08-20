public class TreeIsThisABinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return check(node.left, min, node.data - 1) && check(node.right, node.data + 1, max);
    }

    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

    }
}
