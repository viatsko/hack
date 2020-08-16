int candles(int candlesNumber, int makeNew) {
  int leftovers = candlesNumber * makeNew;

  int burned = 0;

  while (leftovers >= makeNew) {
    int temp_burned = leftovers / makeNew;

    burned += temp_burned;

    leftovers = temp_burned + leftovers % makeNew;
  }

  return burned;
}
