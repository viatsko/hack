function delayingDecorator(f, timeout) {
    return function(...args) {
        setTimeout(() => f.apply(this, args), timeout);
    }
}
