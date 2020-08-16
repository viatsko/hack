#include <string>

std::string properNounCorrection(std::string noun) {
  noun[0] = toupper(noun[0]);

  for (std::string::size_type i = 1; i < noun.size(); i++) {
    noun[i] = tolower(noun[i]);
  }

  return noun;
}
