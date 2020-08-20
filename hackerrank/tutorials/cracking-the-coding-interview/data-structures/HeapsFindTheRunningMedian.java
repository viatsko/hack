import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapsFindTheRunningMedian {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (minHeap.size() <= maxHeap.size()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }

            while (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
                int min = minHeap.poll();
                int max = maxHeap.poll();

                minHeap.add(max);
                maxHeap.add(min);
            }

            double median = (minHeap.size() == maxHeap.size() ? ((minHeap.peek() + maxHeap.peek()) / 2.0) : minHeap.peek());

            System.out.println(median);
        }
    }
}
