import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    private Queue<Integer> queue;
    private int maxSize = 0;
    private int size = 0;
    private int currentTotal = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        maxSize = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (size >= maxSize) {
            int toRemove = queue.poll();
            currentTotal -= toRemove;
        } else size++;

        queue.add(val);
        currentTotal += val;

        return currentTotal * 1.0 / size;
    }
}
