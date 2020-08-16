class Solution {
public:
    int lengthOfLastWord(string s) {
        int end = s.size() - 1;

        while(s[end] == ' ') end--;

        for (int i = end; i >= 0; i--) {
            if (s[i] == ' ') {
                return s.substr(i + 1, end - i).size();
            }
        }

        return end + 1;
    }
};
