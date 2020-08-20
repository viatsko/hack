import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if(node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNotLeavesSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNotLeavesSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0) {
            evenDepthNotLeavesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class JavaVisitorPattern {
    private static void solve(TreeNode parent, Integer parentIndex, int[] values, Color[] colors, Map<Integer, HashSet<Integer>> edges) {
        for (Integer index : edges.get(parentIndex)) {
            edges.get(index).remove(parentIndex);

            Set<Integer> children = edges.get(index);

            Tree node = (children != null && !children.isEmpty()) ?
                    new TreeNode(values[index - 1], colors[index - 1], parent.getDepth() + 1) :
                    new TreeLeaf(values[index - 1], colors[index - 1], parent.getDepth() + 1);

            parent.addChild(node);

            if (node instanceof TreeNode) {
                solve((TreeNode) node, index, values, colors, edges);
            }
        }
    }

    public static Tree solve() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] values = new int[n];

        Color[] colors = new Color[n];

        Map<Integer, HashSet<Integer>> edges = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            colors[i] = in.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            edges.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            edges.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        if (n == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        } else {
            TreeNode root = new TreeNode(values[0], colors[0], 0);

            solve(root, 1, values, colors, edges);

            return root;
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
