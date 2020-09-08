function smallestDifference(arrayOne, arrayTwo) {
  arrayOne.sort((a, b) => a - b);
  arrayTwo.sort((a, b) => a - b);

  let pointerOne = 0;
  let pointerTwo = 0;

  let result = Math.abs(arrayOne[pointerOne] - arrayTwo[pointerTwo]);
  let resultPair = [arrayOne[pointerOne], arrayTwo[pointerTwo]];

  while (pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
    if (Math.abs(arrayOne[pointerOne] - arrayTwo[pointerTwo]) < result) {
      result = Math.abs(arrayOne[pointerOne] - arrayTwo[pointerTwo]);
      resultPair = [arrayOne[pointerOne], arrayTwo[pointerTwo]];
    }

    if (arrayOne[pointerOne] < arrayTwo[pointerTwo]) {
      pointerOne++;
    } else {
      pointerTwo++;
    }
  }

  return resultPair;
}

// Do not edit the line below.
exports.smallestDifference = smallestDifference;
