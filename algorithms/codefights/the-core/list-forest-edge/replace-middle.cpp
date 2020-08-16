std::vector<int> replaceMiddle(std::vector<int> arr) {
  if (arr.size() % 2 == 0) {
    int mid = arr.size() / 2;

    int median = arr[mid] + arr[mid - 1];

    arr.erase(arr.begin() + mid, arr.begin() + mid + 1);

    arr[mid - 1] = median;
  }

  return arr;
}
