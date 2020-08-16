#include <string>

std::string cipher26(std::string message) {
  char prev = 0;
  for (std::string::size_type i = 0; i < message.size(); i++) {
    char ch = message[i];

    char cur = ch - prev + 'a';

    if (cur < 'a') {
      cur += 26;
    }

    message[i] = cur;

    prev = cur;
  }

  return message;
}
