import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private TrieNode root;

    public class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        int value;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
            value = 0;
        }
    }

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            char ch = key.charAt(i);

            node.children.computeIfAbsent(ch, k -> new TrieNode());

            node = node.children.get(ch);

            if (i == n - 1) {
                node.isEnd = true;
                node.value = val;
            }
        }
    }

    private int searchLeaves(TrieNode node) {
        int sum = node.value;

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            sum += searchLeaves(entry.getValue());
        }

        return sum;
    }

    public int sum(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            node = node.children.get(prefix.charAt(i));

            if (node == null) {
                return 0;
            }
        }

        return searchLeaves(node);
    }
}
