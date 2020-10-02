/**
 * @param {string} num
 * @return {string}
 */
const toHexspeak = function(num) {
  const decNum = parseInt(num, 10);
  const hexStr = decNum.toString(16).split('');

  for (let i = 0; i < hexStr.length; i++)
    if (hexStr[i] >= '2' && hexStr[i] <= '9')
      return 'ERROR';
    else
      hexStr[i] =
        hexStr[i] === '1' ?
        'I' :
        hexStr[i] === '0' ?
        'O' :
        hexStr[i];

  return hexStr.join('').toUpperCase();
};
