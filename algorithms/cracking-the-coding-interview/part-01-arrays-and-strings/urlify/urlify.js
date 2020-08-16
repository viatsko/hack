const urlify = (str, len) => {
    // strings are immutable in js, so we can't really do it in-place efficiently
    let result = '';

    for (let i = 0; i < len; i++) {
        if (str[i] === ' ') {
            result += '%20';
        } else {
            result += str[i];
        }
    }

    return result;
};

console.log(urlify('Mr John Smith    ', 13) === 'Mr%20John%20Smith');
