/**
 * @param {number} num
 * @return {string}
 */
var numberToWords = function(num) {
  const endings = ["", "Thousand", "Million", "Billion"];
  const tenths = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
  const singles = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];

  if (num === 0) {
    return "Zero";
  }

  const processTriplet = (num) => {
    const hundreds = Math.floor(num / 100);

    let secondPart = "";
    if (num % 100 !== 0) {
      if ((num % 100) < singles.length) {
        secondPart = singles[num % 100];
      } else {
        secondPart = `${tenths[Math.floor((num % 100) / 10)]}${num % 10 !== 0 ? " " + singles[num % 10] : ""}`;
      }
    }

    return (hundreds ? `${singles[hundreds]} Hundred` : "") + (secondPart ? `${hundreds ? " " : ""}${secondPart}` : "");
  }

  let result = "";
  let ti = 0;
  while (num > 0) {
    const triplet = num % 1000;
    num = Math.floor(num / 1000);
    const tripletResult = processTriplet(triplet);
    if (tripletResult !== "") {
      result = tripletResult + " " + endings[ti] + " " + result;
    }
    ti++;
  }

  return result.trim();
};
