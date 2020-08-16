#include <sstream>
#include <string>

std::string htmlEndTagByStartTag(std::string startTag) {
    std::ostringstream os;

    os << "</";

    for (std::string::size_type i = 1; isalpha(startTag[i]) && i < startTag.size(); i++) {
        os << startTag[i];
    }

    os << ">";

    return os.str();
}
