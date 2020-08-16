
const findContestMatch = k => {
    let result = [];

    for (let i = 1; i <= k; i++) {
        result.push(i);
    }

    for (let n = 2; n <= k; n = n * 2) {
        let newResult = [];

        for (let i = 0; i < result.length / 2; i++) {
            newResult.push(`(${result[i]},${result[result.length - i - 1]})`)
        }

        result = newResult;
    }

    return result[0];
}
