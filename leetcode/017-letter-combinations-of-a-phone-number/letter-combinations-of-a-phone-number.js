/**
 * @param {string} digits
 * @return {string[]}
 */
const letterCombinations = function(digits) {
    if (digits.length === 0) {
        return [];
    }

    const mp = {};
    mp[2] = 'abc'.split('');
    mp[3] = 'def'.split('');
    mp[4] = 'ghi'.split('');
    mp[5] = 'jkl'.split('');
    mp[6] = 'mno'.split('');
    mp[7] = 'pqrs'.split('');
    mp[8] = 'tuv'.split('');
    mp[9] = 'wxyz'.split('');

    let result = [
        []
    ];

    for (const digit of digits) {
        prev = result;
        result = [];

        for (const letter of mp[+digit]) {
            for (const subResult of prev) {
                result.push(subResult + letter);
            }
        }
    }

    return result;
};
