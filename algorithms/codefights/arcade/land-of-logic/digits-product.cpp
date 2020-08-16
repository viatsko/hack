int largestSingleDigitDivisor(int num) {
  for (int i = 9; i > 1; i--) {
    if (num % i == 0) {
      return i;
    }
  }

  return -1;
}

int digitsProduct(int product) {
  if (product == 0) {
    return 10;
  }

  if (product < 10) {
    return product;
  }

  int num = 0;

  int mult = 1;

  while (product > 1) {
    int divisor = largestSingleDigitDivisor(product);

    if (divisor == -1) {
      return -1;
    }

    num += divisor * mult;
    mult *= 10;

    product /= divisor;
  }

  return num;
}
