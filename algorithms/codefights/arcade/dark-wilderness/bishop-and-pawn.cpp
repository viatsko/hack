#include <string>

bool bishopAndPawn(std::string bishop, std::string pawn) {
  int i = bishop[0] - 'a';
  int j = bishop[1] - '1';

  int k = pawn[0] - 'a';
  int l = pawn[1] - '1';

  return std::abs(l - j) == std::abs(i - k);
}
