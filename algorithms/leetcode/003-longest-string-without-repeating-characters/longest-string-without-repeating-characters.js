const lengthOfLongestSubstring = s => {
    // hash for storing last seen indexes of characters
    const chars = {};

    // maximum interval
    let max = 0;

    // "last good position"
    // this is either a longest substring or a next character after last occurance
    // to understand this, let's take a look at
    //  "ababab"
    //     |
    // here, as you can see after "a" we have "b", but we don't want to start
    // a new search starting with "b", we, in fact, might have "ab" string, so this is the
    // position `current` actually keeps
    let current = 0;

    // using for loop because sometimes leetcode gives string indexes instead of numerics in case of something else's used
    for (let i = 0; i < s.length; i++) {
        // current character
        const c = s[i];

        if (Object.prototype.hasOwnProperty.call(chars, c)) {
            // chars[c] + 1 is the next character after the last occurance,
            // the Math.max check here to check if we, in fact, have another
            // later character which can beat our assumption and which
            // is already represented by "current", e. g. case "abba",
            // we don't want first "a" to be taken into consideration
            // when we are working on a last "a", we want latest "b"
            current = Math.max(current, chars[c] + 1);
        }

        chars[c] = i;

        // just subtracting current position and last good position
        max = Math.max(max, i - current + 1);
    }

    return max;
};
