/**
 * @param {string} S
 * @return {string[]}
 */
const letterCasePermutation = function (str) {
  const chars = str.split("");

  const result = [];

  const permutations = [[]];

  for (const char of chars) {
    const n = permutations.length;
    for (let i = 0; i < n; i++) {
      const oldPermutation = permutations.shift();
      if ((char >= "a" && char <= "z") || (char >= "A" && char <= "Z")) {
        const newPermutation1 = [...oldPermutation, char.toLowerCase()];
        const newPermutation2 = [...oldPermutation, char.toUpperCase()];
        if (newPermutation1.length === str.length) {
          result.push(newPermutation1.join(""));
          result.push(newPermutation2.join(""));
        } else {
          permutations.push(newPermutation1);
          permutations.push(newPermutation2);
        }
      } else {
        const newPermutation = [...oldPermutation, char];
        if (newPermutation.length === str.length) {
          result.push(newPermutation.join(""));
        } else {
          permutations.push(newPermutation);
        }
      }
    }
  }

  return result;
};
