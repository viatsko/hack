bool isPower(int n) {
  if (n == 1) {
    return true;
  }

  float lg = std::log(n);

  for (int i = 1; i <= std::sqrt(n); i++) {
    float p = lg / std::log(i);

    std::cout << i << " " << p << (p - (int)p) << std::endl;

    if((p - (int)p) < std::numeric_limits<float>::epsilon()) {
      return true;
    }
  }

  return false;
}
