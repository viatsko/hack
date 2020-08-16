function containsDuplicates(a) {
  const set = new Set();

  for (const num of a) {
    if (set.has(num)) {
      return true;
    }

    set.add(num);
  }

  return false;
}
