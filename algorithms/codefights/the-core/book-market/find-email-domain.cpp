#include <string>

std::string findEmailDomain(std::string address) {
  return address.substr(address.find_last_of("@") + 1);
}
