/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
  public int minMeetingRooms(Interval[] intervals) {
      Arrays.sort(intervals, (a, b) -> a.start - b.start);

      PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);

      int max = 0;
      for (Interval interval : intervals) {
          while (!pq.isEmpty() && pq.peek().end <= interval.start) {
              pq.poll();
          }

          pq.offer(interval);

          max = Math.max(max, pq.size());
      }

      return max;
  }
}
