function findRepeatedDnaSequences(s: string): string[] {
  const seen = new Set<string>();
  const res = new Set<string>();

  for (let i = 0; i < s.length - 9; i++) {
    const fragment = s.substring(i, i + 10);
    if (!seen.has(fragment)) {
      seen.add(fragment);
    } else {
      res.add(fragment);
    }
  }

  return [...res];
}
