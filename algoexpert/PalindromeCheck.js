function isPalindrome(string) {
  for (let i = 0, j = string.length - 1; i < j; i++, j--) {
    if (string[i] !== string[j]) {
      return false;
    }
  }
  return true;
}

// Do not edit the line below.
exports.isPalindrome = isPalindrome;
