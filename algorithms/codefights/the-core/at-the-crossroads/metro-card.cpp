std::vector<int> metroCard(int lastNumberOfDays) {
  if (lastNumberOfDays == 30) {
    return std::vector<int>{ 31 };
  } else if (lastNumberOfDays == 28) {
    return std::vector<int>{ 31 };
  } else if (lastNumberOfDays == 31) {
    return std::vector<int>{ 28, 30, 31 };
  }
}
