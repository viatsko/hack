/**
 * Definition for knows()
 *
 * @param {integer} person a
 * @param {integer} person b
 * @return {boolean} whether a knows b
 * knows = function(a, b) {
 *     ...
 * };
 */

/**
 * @param {function} knows()
 * @return {function}
 */
const solution = function(knows) {
  /**
   * @param {integer} n Total people
   * @return {integer} The celebrity
   */
  return function(n) {
    if (n <= 1) {
      return -1;
    }

    let a = 0;
    let b = 1;

    for (let i = 2; i <= n; i++) {
      if (knows(a, b)) {
        a = b;
      }

      b = i;
    }

    for (let i = 0; i < n; i++) {
      if (i !== a) {
        if (!knows(i, a) || knows(a, i)) {
          return -1;
        }
      }
    }

    return a;
  };
};
