function checkIfExist(arr: number[]): boolean {
  const set = new Set<number>();

  for (const num of arr) {
    if (set.has(num * 2) || set.has(num / 2)) {
      return true;
    }
    set.add(num);
  }

  return false;
}
