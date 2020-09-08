// 5, 0, -1, -8, -9

function maxSatisfaction(satisfaction: number[]): number {
  satisfaction.sort((a, b) => b - a);

  let result = 0;

  let total = 0;
  for (let i = 0; i < satisfaction.length; i++) {
    if (satisfaction[i] > -total) {
      total += satisfaction[i];
      result += total;
    } else {
      break;
    }
  }

  return result;
}
