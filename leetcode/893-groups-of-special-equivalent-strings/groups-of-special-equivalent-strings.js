var getId = (word) => {
  const odd = [];
  const even = [];
  for (let i = 0; i < word.length; i++) {
    if (i % 2 === 0) {
      even.push(word[i]);
    } else {
      odd.push(word[i]);
    }
  }
  return odd.sort().join("") + even.sort().join("");
};

/**
 * @param {string[]} A
 * @return {number}
 */
var numSpecialEquivGroups = function (A) {
  const groups = new Set();

  for (const word of A) {
    groups.add(getId(word));
  }

  return groups.size;
};
