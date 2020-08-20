import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue())
        );

        queue.addAll(map.entrySet());

        while (k-- > 0) {
            result.add(queue.poll().getKey());
        }

        return result;
    }
}
