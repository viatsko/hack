const oneAway = (str1, str2) => {
    if (Math.abs(str1.length - str2.length) > 1) {
        return false;
    }

    let edits = 0;

    for (let i = 0, j = 0; i < str1.length || j < str2.length; i++, j++) {
        if (str1[i] !== str2[j]) {
            if (str1[i] === str2[j + 1]) {
                j++;
            } else if (str2[j] === str1[i + 1]) {
                i++;
            }

            edits++;
        }
    }

    return edits <= 1;
};

console.log(oneAway('pale', 'ple') === true);
console.log(oneAway('pales', 'pale') === true);
console.log(oneAway('pale', 'bale') === true);
console.log(oneAway('pale', 'bake') === false);
