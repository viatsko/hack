function minimumAbsDifference(arr: number[]): number[][] {
  arr.sort((a, b) => a - b);

  const map: { [key: number]: number[][] } = {};

  for (let i = 1; i < arr.length; i++) {
    const dist = arr[i] - arr[i - 1];
    if (!map[dist]) {
      map[dist] = [];
    }
    map[dist].push([arr[i - 1], arr[i]]);
  }

  const minDist = +Object.keys(map).sort((a, b) => +a - +b)[0];

  return map[minDist];
}
