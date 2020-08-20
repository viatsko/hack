const isSubstring = (big, small) => {
    return big.includes(small);
};

const checkRotation = (str1, str2) => {
    for (let i = 0; i < str1.length; i++) {
        if (isSubstring(str2, str1.substr(i) + str1.substring(0, i))) {
            return true;
        }
    }

    return false;
};

console.log(checkRotation('waterbottle', 'erbottlewat') === true);
