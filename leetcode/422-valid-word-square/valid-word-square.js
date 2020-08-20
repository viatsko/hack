const validWordSquare = words => {
    for (let i = 0; i < words.length; i++) {
        for (let j = 0; j < words[i].length; j++) {
            if (!words[i] || !words[j] || words[i][j] !== words[j][i]) {
                return false;
            }
        }
    }

    return true;
};
