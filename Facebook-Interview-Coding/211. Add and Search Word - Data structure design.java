211. Add and Search Word - Data structure design

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true


Time: add / search: O(wordLength) average, For search -> max O(26^n)
Space: O(numOfTrieNode * 26) = O(numOfWords * wordLength * 26)

public class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }
    private boolean dfs(char[] word, int start, TrieNode root) {
        if (start == word.length)     return root.isWord;
        char c = word[start];
        if (c == '.') {
            for (int i = 0; i < 26; i++)
                if (root.children[i] != null && dfs(word, start + 1, root.children[i]))     return true;
        } else {
            if (root.children[c - 'a'] != null) 
                return dfs(word, start + 1, root.children[c - 'a']);
        }
        return false;
    }
}

*******************follow up******************
如果模糊查询只有"...book"和“book...”这两种模式怎么处 ，
回答，只要建 顺序 tire树，反序tire树，就可以 。







