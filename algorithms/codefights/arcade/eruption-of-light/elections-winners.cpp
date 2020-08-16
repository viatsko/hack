#include <climits>
#include <vector>

int electionsWinners(std::vector<int> votes, int k) {
  int result = 0;

  int max = INT_MIN;
  int maxN = 0;

  for (std::vector<int>::size_type i = 0; i < votes.size(); i++) {
    if (votes[i] > max) {
      max = votes[i];
      maxN = 1;
    } else if (votes[i] == max) {
      maxN++;
    }
  }

  if (k == 0) {
    return maxN == 1 ? 1 : 0;
  }


  for (int const& vote : votes) {
    if (vote + k > max) {
      result++;
    }
  }

  return result;
}
