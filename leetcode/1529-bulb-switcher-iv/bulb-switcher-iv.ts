function minFlips(target: string): number {
  let res = 0;
  let prev = "0";
  for (let i = 0; i < target.length; i++) {
    if (prev !== target[i]) {
      res++;
      prev = target[i];
    }
  }
  return res;
}
