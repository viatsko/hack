import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue().equals(a.getValue()) ? b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue())
        );

        queue.addAll(map.entrySet());

        while (k-- > 0) {
            result.add(queue.poll().getKey());
        }

        return result;
    }
}
