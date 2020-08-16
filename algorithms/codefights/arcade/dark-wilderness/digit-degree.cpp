int digitDegree(int n) {
    if (n < 10) {
        return 0;
    }

    for (unsigned int i = 0; i < 10; i++) {
        unsigned int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        if (sum < 10) {
            return i + 1;
        }

        n = sum;
    }

    return -1;
}
