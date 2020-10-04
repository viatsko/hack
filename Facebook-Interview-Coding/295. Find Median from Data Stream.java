295. Find Median from Data Stream
// https://leetcode.com/problems/find-median-from-data-stream/
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2


public class MedianFinder {
    PriorityQueue<Integer> minHeap; // larger part
    PriorityQueue<Integer> maxHeap; // smaller part
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (minHeap.size() < maxHeap.size())
            minHeap.offer(maxHeap.poll());
    }
    // Returns the median of current data stream
    public double findMedian() {
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}