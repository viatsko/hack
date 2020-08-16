
const reverseStr = (s, k) => {
    let result = '';

    for (let i = 0; i < s.length; i += 2 * k) {
        result += (s.substr(i, k).split('').reverse().join('') + s.substr(i + k, k));
    }

    return result;
}
