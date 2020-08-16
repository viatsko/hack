#include <sstream>
#include <string>

bool isIPv4Address(std::string inputString) {
      std::istringstream ss(inputString);
      std::string token;
      
      unsigned int parts = 0;

      while(std::getline(ss, token, '.')) {
            if (token.size() == 0 || token.find_first_not_of("0123456789") != std::string::npos) {
                  return false;
            } else {
                  int num;
                  
                  // -.- std::stoi is not available on CodeFights
                  std::stringstream ss2;
                  ss2 << token;
                  ss2 >> num;
                  
                  if (num > 255) {
                        return false;
                  }
            }
            
            parts++;
      }
      
      return parts == 4;
}
