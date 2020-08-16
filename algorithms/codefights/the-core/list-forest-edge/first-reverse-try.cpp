std::vector<int> firstReverseTry(std::vector<int> arr) {
  if (arr.size() == 0) {
    return std::vector<int>();
  }

  if (arr.size() == 1) {
    return arr;
  }

  int tmp = arr[0];
  arr[0] = arr[arr.size() - 1];
  arr[arr.size() - 1] = tmp;

  return arr;
}
