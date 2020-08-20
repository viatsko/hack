const canAttendMeetings = intervals => {
    intervals.sort((a, b) => ((a.start - b.start) || (a.end - b.end)));

    for (let i = 0; i < intervals.length; i++) {
        let end = intervals[i].end;

        if (i < (intervals.length - 1) && (end > intervals[i + 1].start)) {
            return false;
        }
    }

    return true;
};
