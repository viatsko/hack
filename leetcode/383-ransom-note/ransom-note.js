
const canConstruct = (ransomNote, magazine) => {
    const mh = {};

    for (let i = 0; i < magazine.length; i++) {
        mh[magazine[i]] = -~mh[magazine[i]];
    }

    for (let i = 0; i < ransomNote.length; i++) {
        if (!mh.hasOwnProperty(ransomNote[i])) {
            return false;
        }

        if (mh[ransomNote[i]] === 0) {
            return false;
        }

        mh[ransomNote[i]]--;
    }

    return true;
}
