#include <string>

int commonCharacterCount(std::string s1, std::string s2) {
    int common = 0;
    
    unsigned int chars1[256] = {0};
    unsigned int chars2[256] = {0};
    
    for (std::string::size_type i = 0; i < s1.size(); i++) {
        chars1[s1[i]]++;
    }
    
    for (std::string::size_type i = 0; i < s2.size(); i++) {
        chars2[s2[i]]++;
    }
    
    for (unsigned int i = 0; i < 256; i++) {
        if (chars1[i] > 0 && chars2[i] > 0) {
            if (chars1[i] < chars2[i]) {
                common += chars1[i];
            } else {
                common += chars2[i];
            }
        }
    }
    
    return common;
}
