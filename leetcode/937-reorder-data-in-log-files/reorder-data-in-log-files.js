/**
 * @param {string[]} logs
 * @return {string[]}
 */
const reorderLogFiles = function(logs) {
  return logs.sort((a, b) => {
    const aSplit = a.split(' ');
    const bSplit = b.split(' ');

    let aAlpha = (aSplit[1][0] >= 'a' && aSplit[1][0] <= 'z');
    let bAlpha = (bSplit[1][0] >= 'a' && bSplit[1][0] <= 'z');

    if (aAlpha && bAlpha) {
      aSplit.push(aSplit.shift());
      bSplit.push(bSplit.shift());
      return aSplit.join(' ').localeCompare(bSplit.join(' '));
    } else if (aAlpha) {
      return -1;
    } else if (bAlpha) {
      return 1;
    } else {
      return 0;
    }
  })
};
