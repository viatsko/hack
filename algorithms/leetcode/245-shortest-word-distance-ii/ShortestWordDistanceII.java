public class ShortestWordDistanceII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (pos != -1 && (word1.equals(word2) || !words[pos].equals(words[i]))) {
                    min = Math.min(i - pos, min);
                }

                pos = i;
            }
        }

        return min;
    }
}
