#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

class Solution {
public:
    std::vector<std::string> subdomainVisits(std::vector<std::string>& cpdomains) {
      std::map<std::string, int> domains;

      for (std::string const& cpdomain: cpdomains) {
        int sep_pos = cpdomain.find(' ');

        std::string count = cpdomain.substr(0, sep_pos);

        std::string domain = cpdomain.substr(sep_pos + 1);

        domains[domain] += std::stoi(count);

        for (std::string::size_type i = 0; i < domain.size(); i++) {
          if (domain[i] == '.') {
            domains[domain.substr(i + 1)] += std::stoi(count);
          }
        }
      }

      std::vector<std::string> result;
      for(auto const& entry : domains) {
        std::ostringstream oss;
        oss << entry.second << ' ' << entry.first;
        result.push_back(oss.str());
      }

      return result;
    }
};
