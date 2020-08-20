import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TriesContacts {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();

        int wordsCount = 0;

        boolean isWord = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        TrieNode root = new TrieNode();

        root.wordsCount = 0;

        for (int i = 0; i < t; i++) {
            String op = scanner.next();

            String word = scanner.next();

            int l = word.length();

            if (op.equals("add")) {
                TrieNode node = root;

                root.wordsCount++;

                for (int j = 0; j < l; j++) {
                    char ch = word.charAt(j);

                    node.children.putIfAbsent(ch, new TrieNode());

                    node = node.children.get(ch);

                    node.wordsCount++;
                }

                node.isWord = true;
            } else if (op.equals("find")) {
                TrieNode node = root;

                for (int j = 0; j < l; j++) {
                    char ch = word.charAt(j);

                    node = node.children.get(ch);

                    if (node == null) {
                        break;
                    }
                }

                System.out.println(node == null ? 0 : node.wordsCount);
            }
        }
    }
}
