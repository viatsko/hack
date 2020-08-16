#include <string>
#include <iostream>

std::string reverseParentheses(std::string s) {
    std::string::size_type begin = 0;
    std::string::size_type end = 0;
    
    for (std::string::size_type i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            std::cout << "begin set!" << i << std::endl;
            begin = i;
        } else if (s[i] == ')') {
            end = i;
            std::string mid = s.substr(begin + 1, end - begin - 1);
            std::reverse(mid.begin(), mid.end());
            return reverseParentheses(s.substr(0, begin) + mid + s.substr(end + 1));
        }
    }
    
    return s;
}
