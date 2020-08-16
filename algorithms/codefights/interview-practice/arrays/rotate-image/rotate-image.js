function rotateImage(a) {
    const l = a.length;

    for (let i = 0; i < l / 2; i++) {
        for (let j = i; j < l - i - 1; j++) {
            let tmp = a[i][j];
            a[i][j] = a[l - j - 1][i];
            a[l - j - 1][i] = a[l - i - 1][l -j - 1];
            a[l - i - 1][l -j - 1] = a[j][l - i - 1];
            a[j][l - i - 1] = tmp;
        }
    }

    return a;
}
