int divisors(int n, std::map<int, int>& memo) {
  std::map<int, int>::iterator it = memo.find(n);
  if (it != memo.end()) {
    return it->second;
  }

  int result = 0;

  for (int i = 1; i <= sqrt(n); i++) {
    if (n % i == 0) {
      if (n / i == i) {
        result++;
      } else {
        result += 2;
      }
    }
  }

  memo.insert(std::pair<int, int>{ n, result });

  return result;
}

std::vector<int> weakNumbers(int n) {
  std::map<int, int> memo;

  int max = INT_MIN;
  int count = 0;

  for (int i = 1; i <= n; i++) {
    int current = 0;

    int ds = divisors(i, memo);
    for (int j = 1; j < i; j++) {
      if (divisors(j, memo) > ds) {
        current++;
      }
    }

    if (current > max) {
      max = current;
      count = 1;
    } else if (current == max) {
      count++;
    }
  }

  return std::vector<int>{ max, count };
}
