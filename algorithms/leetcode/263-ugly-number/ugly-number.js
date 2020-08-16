const isUgly = num => {
    if (num <= 0) {
        return false;
    }

    for (const div of [2, 3, 5]) {
        while (num % div === 0) {
            num = num / div | 0;
        }
    }

    return num === 1;
};
