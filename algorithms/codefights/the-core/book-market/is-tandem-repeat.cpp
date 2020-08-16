bool isTandemRepeat(std::string inputString) {
    if (inputString.size() % 2 == 1) {
        return false;
    }

    std::string::size_type mid = inputString.size() / 2;

    for (std::string::size_type i = 0; i < mid; i++) {
        if (inputString[i] != inputString[i + mid]) {
            return false;
        }
    }

    return true;
}
