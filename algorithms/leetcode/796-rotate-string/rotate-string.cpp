class Solution {
public:
    bool rotateString(std::string A, std::string B) {
        return (A + A).find(B) != std::string::npos;
    }
};
