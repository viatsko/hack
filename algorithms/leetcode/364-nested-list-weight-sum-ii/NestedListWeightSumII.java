import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeightSumII {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int result = 0;
    int maxLevel = 0;

    Map<Integer, Integer> levels = new HashMap<>();

    private void recurse(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                levels.compute(depth, (key, value) -> value == null ? nestedInteger.getInteger() : (value + nestedInteger.getInteger()));
                maxLevel = Math.max(maxLevel, depth + 1);
            } else {
                recurse(nestedInteger.getList(), depth + 1);
            }
        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        recurse(nestedList, 0);

        for (Map.Entry<Integer, Integer> entry : levels.entrySet()) {
            result += entry.getValue() * (maxLevel - entry.getKey());
        }

        return result;
    }
}
