function sumTo(n) {
    let result = 0;

    for (let i = 1; i <= n; i++) {
        result += i;
    }

    return result;
}

process.stdout.write(String(sumTo(100)));
