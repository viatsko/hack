/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
const getHint = function (secret, guess) {
  const occ = [];

  let bulls = 0;
  let cows = 0;

  for (let i = 0; i < secret.length; i++) {
    if (secret[i] === guess[i]) {
      bulls++;
    } else {
      occ[secret[i]] = -~occ[secret[i]];
    }
  }

  for (let i = 0; i < secret.length; i++) {
    if (secret[i] !== guess[i] && occ[guess[i]] > 0) {
      occ[guess[i]]--;
      cows++;
    }
  }

  return bulls + "A" + cows + "B";
};
