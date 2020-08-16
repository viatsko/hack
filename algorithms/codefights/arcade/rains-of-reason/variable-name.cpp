#include <string>

bool variableName(std::string name) {
    for (std::string::size_type i = 0; i < name.size(); i++) {
        char ch = name[i];
        
        if (
            !(
                (ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (i != 0 && ch >= '0' && ch <= '9') ||
                ch == '_'
            )
        ) {
            return false;
        }
    }
    
    return true;
}
