
const firstUniqChar = s => {
    const mp = {};

    for (let i = 0; i < s.length; i++) {
        mp[s[i]] = -~mp[s[i]];
    }

    for (let i = 0; i < s.length; i++) {
        if (mp[s[i]] === 1) {
            return i;
        }
    }

    return -1;
}
