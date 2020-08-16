int rounders(int value) {
  float mult = 10;

  for (int i = 1; i <= log10(value); i++) {
    value = std::round((double) value / mult) * mult;

    mult *= 10;
  }

  return value;
}
