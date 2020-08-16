function throttle(f, timeout) {
    let lastContext = null;
    let lastArgs = [];

    let isThrottled = false;

    return function innerF(...args) {
        if (isThrottled) {
            lastContext = this;
            lastArgs = args;

            return;
        }

        f.apply(this, args);

        isThrottled = true;

        setTimeout(function() {
            isThrottled = false;

            if (lastContext && lastArgs) {
                innerF.apply(lastContext, lastArgs);

                lastContext = lastArgs = null;
            }
        }, timeout);
    }
}
