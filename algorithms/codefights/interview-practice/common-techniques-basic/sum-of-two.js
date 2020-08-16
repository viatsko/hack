function sumOfTwo(a, b, v) {
  const aSet = new Set(a);

  for (const num of b) {
    if (aSet.has(v - num)) {
      return true;
    }
  }

  return false;
}
