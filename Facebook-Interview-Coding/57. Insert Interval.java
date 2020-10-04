57. Insert Interval
// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

此题思路就是非常straight forward的三步：
1.add newInterval之前的
2.add 和newInterval重叠的
3.add newInterval之后的

public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
        res.add(intervals.get(i++));
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        i++;
    }
    res.add(newInterval);
    while (i < intervals.size())    res.add(intervals.get(i++));
    return res;
}

[注意]
// if output is total interval time, then array should be sorted to get the time
// if output should be sorted, we may need to sort the array
// if output should be not overlapping, we may need to merge intervals



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


