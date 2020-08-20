import java.util.Arrays;

public class MagicDictionary {
    private class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
    }

    private static final int A = (int)'a';

    private TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String string : dict) {
            TrieNode node = root;

            int n = string.length();

            for (int i = 0; i < n; i++) {
                int index = string.charAt(i) - A;

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.isWord = true;
        }
    }

    private boolean search(TrieNode node, String word, int position, int editions) {
        if (node == null || editions > 1) {
            return false;
        }

        if (position == word.length()) {
            return node.isWord && editions == 1;
        }

        return Arrays.stream(node.children)
                .anyMatch(
                        nextChild -> search(
                                nextChild,
                                word,
                                position + 1,
                                node.children[word.charAt(position) - A] == nextChild ? editions : editions + 1
                        )
                );
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode node = root;

        return search(node, word, 0, 0);
    }
}
