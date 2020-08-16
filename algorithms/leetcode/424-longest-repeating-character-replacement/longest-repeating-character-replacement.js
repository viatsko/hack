/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function (s, k) {
    const chars = {};

    let start = 0;
    let uniqueCount = 0;
    let result = 0;

    for (let i = 0; i < s.length; i++) {
        const ch = s[i];

        chars[ch] = -~chars[ch];
        uniqueCount = Math.max(chars[ch], uniqueCount);

        const nonRepeat = i - start + 1 - uniqueCount;

        if (nonRepeat > k) {
            chars[s[start++]]--;
        } else {
            result = Math.max(result, i - start + 1);
        }
    }

    return result;
};
