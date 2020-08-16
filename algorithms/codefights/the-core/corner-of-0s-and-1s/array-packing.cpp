int arrayPacking(std::vector<int> a) {
  int result = 0;

  for (std::vector<int>::size_type i = 0; i < a.size(); i++) {
    result += a[i] << (i * 8);
  }

  return result;
}
