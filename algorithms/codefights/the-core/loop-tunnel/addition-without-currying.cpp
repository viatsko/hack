int additionWithoutCarrying(int param1, int param2) {
  int mult = 1;

  int result = 0;

  while(param1 > 0 || param2 > 0) {
    int temp = (param1 % 10 + param2 % 10) % 10;

    result += temp * mult;
    param1 /= 10;
    param2 /= 10;
    mult *= 10;
  }

  return result;
}
