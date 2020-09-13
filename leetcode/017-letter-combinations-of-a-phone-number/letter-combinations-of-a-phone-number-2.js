const rel = {};
rel[2] = ["a", "b", "c"];
rel[3] = ["d", "e", "f"];
rel[4] = ["g", "h", "i"];
rel[5] = ["j", "k", "l"];
rel[6] = ["m", "n", "o"];
rel[7] = ["p", "q", "r", "s"];
rel[8] = ["t", "u", "v"];
rel[9] = ["w", "x", "y", "z"];

/**
 * @param {string} digits
 * @return {string[]}
 */
const letterCombinations = function (digits, pos = 0) {
  if (pos === digits.length) {
    return [];
  }

  if (pos === digits.length - 1) {
    return rel[+digits[pos]];
  }

  const result = [];

  for (const letter of rel[+digits[pos]]) {
    for (combination of letterCombinations(digits, pos + 1)) {
      result.push(letter + combination);
    }
  }

  return result;
};
