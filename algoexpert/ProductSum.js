// Tip: You can use the Array.isArray function to check whether an item
// is a list or an integer.
function productSum(array, depth = 1) {
  let result = 0;

  for (const el of array) {
    if (Array.isArray(el)) {
      result += (depth + 1) * productSum(el, depth + 1);
    } else {
      result += el;
    }
  }

  return result;
}

// Do not edit the line below.
exports.productSum = productSum;
