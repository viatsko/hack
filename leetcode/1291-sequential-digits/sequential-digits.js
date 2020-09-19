/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
const sequentialDigits = function(low, high) {
  // let lowd = Math.floor(Math.log10(low) + 1);
  // let hid = Math.floor(Math.log10(low) + 1);

  const res = [];
  for (let j = 1; j <= 9; j++) {
    let str = '';
    for (let i = j; i <= 9; i++) {
      str += i;
      if (+str >= low && +str <= high) {
        res.push(+str)
      }
    }
  }
  res.sort((a, b) => Math.floor(Math.log10(a)) - Math.floor(Math.log10(b)));
  return res;
};
