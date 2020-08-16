function firstDuplicate(a) {
    let abs = -1;

    for (let i = 0; i < a.length; i++) {
        abs = Math.abs(a[i]);

        if (a[abs - 1] > 0) {
            a[abs - 1] = -a[abs - 1];
        } else {
            return abs;
        }
    }

    return abs;
}
