int pagesNumberingWithInk(int current, int numberOfDigits) {
  std::string str = std::to_string(current);

  while (str.size() <= numberOfDigits) {
    str += std::to_string(++current);
  }

  return current - 1;
}
