const stringCompression = str => {
    let result = '';

    for (let i = 0; i < str.length; i++) {
        const ch = str[i];

        let count = 1;

        while(str[i + 1] === ch) {
            count++;
            i++;
        }

        result += ch + count;
    }

    return result.length > str.length ? str : result;
};

console.log(stringCompression('aabcccccaaa') === 'a2b1c5a3');
