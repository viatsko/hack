import java.util.*;

class WordSearchII {
    class PrefixResult {
        boolean exists;
        boolean fullWord;

        PrefixResult(boolean exists, boolean fullWord) {
            this.exists = exists;
            this.fullWord = fullWord;
        }

        public String toString() {
            return "Exists = " + this.exists + ", Full Word = " + this.fullWord;
        }
    }

    class Trie {
        Map<Character, Object> root = new HashMap<>();

        void put(String string) {
            Map<Character, Object> node = root;

            for (int i = 0; i < string.length(); i++) {
                Character ch = string.charAt(i);

                if (node.get(ch) != null) {
                    node = (Map<Character, Object>) node.get(ch);
                } else {
                    Map<Character, Object> newNode = new HashMap<>();

                    node.put(ch, newNode);

                    node = newNode;
                }
            }

            node.put('$', new HashMap<Character, Object>());
        }

        PrefixResult containsPrefix(String prefix) {
            Map<Character, Object> node = root;

            for (int i = 0; i < prefix.length(); i++) {
                node = (Map<Character, Object>) node.get(prefix.charAt(i));

                if (node == null) {
                    return new PrefixResult(false, false);
                }
            }

            return new PrefixResult(true, node.get('$') != null);
        }
    }

    private void dfs(char[][] board, int i, int j, Trie trie, String current, HashMap<String, Boolean> result) {
        char c = board[i][j];

        if (c == '0') {
            return;
        }

        String newCurrent = current + c;

        PrefixResult prefixResult = trie.containsPrefix(newCurrent);

        if (!prefixResult.exists) {
            return;
        }

        if (prefixResult.fullWord) {
            result.putIfAbsent(newCurrent, true);
        }

        board[i][j] = '0';

        if (i > 0) {
            dfs(board, i - 1, j, trie, newCurrent, result);
        }

        if (j > 0) {
            dfs(board, i, j - 1, trie, newCurrent, result);
        }

        if (i < board.length - 1) {
            dfs(board, i + 1, j, trie, newCurrent, result);
        }

        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, trie, newCurrent, result);
        }

        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.put(word);
        }

        LinkedHashMap<String, Boolean> result = new LinkedHashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, "", result);
            }
        }

        List<String> resultList = new ArrayList<>();

        resultList.addAll(result.keySet());

        return resultList;
    }
}
