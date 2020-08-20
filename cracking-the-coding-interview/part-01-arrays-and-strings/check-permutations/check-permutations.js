const checkPermutations = (str1, str2) => {
    if (str1.length !== str2.length) {
        return false;
    }

    const sortString = str => {
        const arr = str.split('');

        arr.sort(); // alphabetical sort

        return arr.join('');
    };

    return sortString(str1) === sortString(str2);
};

console.log(checkPermutations('ab', 'ba') === true);
console.log(checkPermutations('ab', 'ab') === true);
console.log(checkPermutations('ab', 'ac') === false);
