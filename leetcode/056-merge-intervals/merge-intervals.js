const merge = intervals => {
    const result = [];

    intervals.sort((a, b) => ((a.start - b.start) || (a.end - b.end)));

    for (let i = 0; i < intervals.length; i++) {
        const start = intervals[i].start;
        let end = intervals[i].end;

        while (i < (intervals.length - 1) && (end >= intervals[i + 1].start)) {
            end = Math.max(intervals[i + 1].end, end);
            i++;
        }

        result.push(new Interval(start, end));
    }

    return result;
};
