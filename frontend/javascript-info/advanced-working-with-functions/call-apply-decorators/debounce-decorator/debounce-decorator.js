function debounce(f, timeout) {
    let ignore = false;

    return function(...args) {
        if (ignore) {
            return;
        }

        ignore = true;

        f.apply(this, args);

        setTimeout(function() {
            ignore = false;
        }, timeout);
    }
}
