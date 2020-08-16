
const generatePossibleNextMoves = s => {
    const result = [];

    for (let i = 0; i < s.length - 1; i++) {
        if (s[i] === '+' && s[i + 1] === '+') {
            const arr = s.split('');

            arr[i] = '-';
            arr[i + 1] = '-';

            result.push(arr.join(''));
        }
    }

    return result;
}
