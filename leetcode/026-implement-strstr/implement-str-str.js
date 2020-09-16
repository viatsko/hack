const check = (haystack, needle, index) => {
  for (let j = 0; j < needle.length; j++) {
    if (haystack[index + j] !== needle[j]) {
      return false;
    }
  }

  return true;
};

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
const strStr = function (haystack, needle) {
  if (haystack === needle) {
    return 0;
  }
  if (needle.length > haystack.length) {
    return -1;
  }

  for (let i = 0; i < haystack.length - needle.length + 1; i++) {
    if (check(haystack, needle, i)) {
      return i;
    }
  }

  return -1;
};
