bool isSmooth(std::vector<int> arr) {
  int median =
      arr.size() % 2 == 0 ?
      arr[arr.size() / 2] + arr[arr.size() / 2 - 1] :
      arr[arr.size() / 2];

  return arr[0] == arr[arr.size() - 1] && arr[0] == median;
}
