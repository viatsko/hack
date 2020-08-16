bool isCaseInsensitivePalindrome(std::string inputString) {
    int i = 0;
    int j = inputString.size() - 1;

    while (i < j) {
        if (tolower(inputString[i++]) != tolower(inputString[j--])) {
            return false;
        }
    }

    return true;
}
