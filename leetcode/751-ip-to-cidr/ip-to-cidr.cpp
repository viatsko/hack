#include <iostream>
#include <sstream>
#include <string>
#include <vector>

class Solution {
public:
    uint32_t ipToInt(std::string ip) {
      uint32_t result = 0;

      for (std::string::size_type i = 0; i < ip.size(); i++) {
        std::string::size_type j;

        for (j = i; ip[j] != '.' && j < ip.size(); j++);

        std::string substr = ip.substr(i, j - i);

        uint32_t triple = (uint32_t) std::stol(substr);

        result *= 256;
        result += triple;

        i = j;
      }

      return result;
    }

    std::string intToIp(uint32_t ip) {
      std::vector<std::string> triples(4);

      for (int i = 0; i < 4; i++) {
        triples[3 - i] = std::to_string(ip & 255);
        ip >>= 8;
      }

      return triples[0] + '.' + triples[1] + '.' + triples[2] + '.' + triples[3];
    }

    std::vector<std::string> ipToCIDR(std::string ip, int n) {
      std::vector<std::string> result;

      uint32_t current_ip = ipToInt(ip);

      while (n > 0) {
        int step = current_ip & -current_ip;

        while (step > n) {
          step >>= 1;
        }

        std::ostringstream oss;
        oss << intToIp(current_ip) << '/';

        int current_step = step,
            mask = 32;
        while (current_step > 1) {
          current_step >>= 1;
          mask--;
        }

        oss << mask;

        result.push_back(oss.str());

        current_ip += step;
        n -= step;
      }

      return result;
    }
};
