function work(a, b) {
    process.stdout.write(String(a + b) + '\n'); // work is an arbitrary function or method
}

const spy = function(f) {
    function innerFunc(...args) {
        innerFunc.calls.push(args);

        return f.apply(this, args);
    }

    innerFunc.calls = [];

    return innerFunc;
};

work = spy(work);

work(1, 2); // 3
work(4, 5); // 9

for(let args of work.calls) {
    process.stdout.write( 'call:' + args.join() + '\n' ); // "call:1,2", "call:4,5"
}
