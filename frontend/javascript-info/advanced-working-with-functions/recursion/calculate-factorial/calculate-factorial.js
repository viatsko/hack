function factorial(n) {
    if (n <= 1) {
        return n;
    }

    return n * factorial(n - 1);
}

process.stdout.write(String(factorial(5)));
