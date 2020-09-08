function caesarCipherEncryptor(string, key) {
  const chars = string.split("");
  for (let i = 0; i < chars.length; i++) {
    chars[i] = shift(chars[i], key);
  }
  return chars.join("");
}

const startCode = "a".charCodeAt(0);
function shift(letter, key) {
  return String.fromCharCode(
    ((letter.charCodeAt(0) + key - startCode) % 26) + startCode
  );
}

// Do not edit the line below.
exports.caesarCipherEncryptor = caesarCipherEncryptor;
