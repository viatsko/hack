import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Combinations {
    private void combine(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (k == 0) {
            result.add(current.stream().map(Integer::new).collect(Collectors.toList()));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);

            combine(result, current, i + 1, n, k - 1);

            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        combine(result, new ArrayList<>(), 1, n, k);

        return result;
    }
}
