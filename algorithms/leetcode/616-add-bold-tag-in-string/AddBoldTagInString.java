class Solution {
    class Interval {
        int start = -1;
        int end = -1;
        
        Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
    
    private List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        
        int n = intervals.size();
        for (int i = 0; i < n; i++) {
            Interval startInterval = intervals.get(i);
            int end = startInterval.end;
            
            while ((i + 1) < n && intervals.get(i + 1).start <= end) {
                end = Math.max(end, intervals.get(i + 1).end);
                i++;
            }
            
            startInterval.end = end;
            
            result.add(startInterval);
        }
        
        return result;
    }
    
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new LinkedList<>();
        
        for (String str : dict) {
            int n = str.length();
            int index = -1;
            while((index = s.indexOf(str, index)) > -1) {
                int endIndex = index + n;
                intervals.add(new Interval(index, endIndex));
                index++;
            }
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                
                return a.start - b.start;
            }
        });
        
        intervals = mergeIntervals(intervals);
        
        System.out.println("Merged");
        for (Interval interval: intervals) {
            System.out.println(interval.start);
            System.out.println(interval.end);
        }
        
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (Interval interval : intervals) {
            if (interval.start - start > 0) {
                sb.append(s.substring(start, interval.start));
            }
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            start = interval.end;
        }
        
        if (s.length() - start > 0) {
            sb.append(s.substring(start));
        }

        return sb.toString();
    }
}
