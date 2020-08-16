import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    class MedianFinder {
        Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        Queue<Integer> maxHeap = new PriorityQueue<>();

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        @SuppressWarnings("Duplicates")
        public void addNum(int num) {
            if (minHeap.size() <= maxHeap.size()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }

            while (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
                int min = minHeap.poll();
                int max = maxHeap.poll();

                maxHeap.add(min);
                minHeap.add(max);
            }
        }

        public double findMedian() {
            return minHeap.size() == maxHeap.size() ? ((maxHeap.peek() + minHeap.peek()) / 2) : minHeap.peek();
        }
    }
}
