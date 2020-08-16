const longestCommonPrefix = strs => {
    if (!strs.length) {
        return '';
    }

    let common = strs[0];

    for (const str of strs) {
        for (let i = 0; i < common.length; i++) {
            if (str[i] !== common[i]) {
                common = str.substring(0, i);
            }
        }
    }

    return common;
};
