
const eraseOverlapIntervals = intervals => {
    intervals.sort((a, b) => {
        return a.end - b.end || b.start - a.start;
    });

    let maxEnd = Number.NEGATIVE_INFINITY;
    
    let count = 0;

    for (const interval of intervals) {
        if (interval.start >= maxEnd) {
            maxEnd = interval.end;
        } else {
            console.log(interval);
            count++;
        }
    }
    
    return count;
}


